
import static utils.Utilities.writeFile;

import org.objectweb.asm.*;
import org.objectweb.asm.Opcodes;

public class gen9{
    	// Get input (I or D), from the user, run a loop that adds that number to an accumulator, and then print the result. (gen9.java,program9.class)

    public static void main(String[] args){

        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC,"program9", null, "java/lang/Object",null);
        
        {
			MethodVisitor mv=cw.visitMethod(Opcodes.ACC_PUBLIC, "<init>", "()V", null, null);
			mv.visitCode();
			mv.visitVarInsn(Opcodes.ALOAD, 0); //load the first local variable: this
			mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "()V",false);
			mv.visitInsn(Opcodes.RETURN);
			mv.visitMaxs(1,1);
			mv.visitEnd();
		}

        {
            MethodVisitor mv=cw.visitMethod(Opcodes.ACC_PUBLIC+Opcodes.ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
            mv.visitCode();
            
            // Labels for jumping too
            Label jump13 = new Label();
            
            // Get Scanner and store it
            /*
             *  0: new
             *  3: dup
             *  4: getstatic
             *  7: invokespecial
             *  10: astore 1
             */
            mv.visitTypeInsn(Opcodes.NEW, "java/util/Scanner");
            mv.visitInsn(Opcodes.DUP);
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "in", "Ljava/io/InputStream;");
            mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/util/Scanner", "<init>", "(Ljava/io/InputStream;)V", false);
            mv.visitVarInsn(Opcodes.ASTORE, 1);
            
            // Declare accumulator
            /*
             *  11: dconst 0
             *  12: dstore 2
             */
            mv.visitInsn(Opcodes.DCONST_0);
            mv.visitVarInsn(Opcodes.DSTORE, 2);
            
            // 44 jump to 13
            mv.visitLabel(jump13);
            
            // Get user input for double using Scanner
            /*
             *	13: getstatic
             *	16: ldc
             *	18: invokevirtual
             *	21: aload 1
             *	22: invokevirtual
             *	25: dstore 4
             */
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitLdcInsn((String)"Enter double");
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
            mv.visitVarInsn(Opcodes.ALOAD, 1);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/util/Scanner", "nextDouble", "()D", false);
            mv.visitVarInsn(Opcodes.DSTORE, 4);
            
            // Add and store the value to the accumulator
            /*
             *  27: dload 2
             *  28: dload 4
             *  30: dadd
             *  31: dstore 2
             */
            mv.visitVarInsn(Opcodes.DLOAD, 2);
            mv.visitVarInsn(Opcodes.DLOAD, 4);
            mv.visitInsn(Opcodes.DADD);
            mv.visitVarInsn(Opcodes.DSTORE, 2);
            
            // Print the accumulator value
            /*
             *  32: getstatic
             *  35: ldc
             *  37: invokevirtual
             *  40: getstatic
             *  43: dload 2
             *  44: invokevirtual
             */
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitLdcInsn((String)"Accumulator: ");
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "print", "(Ljava/lang/String;)V", false);
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.DLOAD, 2);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(D)V", false);

            // Loop back up
            /*
             *  47: goto 13
             */
            mv.visitJumpInsn(Opcodes.GOTO, jump13);
            
            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(0,0);
            mv.visitEnd();
        }

        cw.visitEnd();

        byte[] b = cw.toByteArray();

        writeFile(b,"program9.class");
        
        System.out.println("Done!");
    }//end main
}//end class

