
import static utils.Utilities.writeFile;

import org.objectweb.asm.*;
import org.objectweb.asm.Opcodes;

public class gen7{
    	// Implement a While Loop (gen7.java,program7.class)

    public static void main(String[] args){

        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC,"program7", null, "java/lang/Object",null);
        
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
            Label jump2 = new Label();
            Label jump19 = new Label();

            // Declare Variable
            /*
             *  0: iconst 3
             *  1: istore 1
             */
            mv.visitInsn(Opcodes.ICONST_3);
            mv.visitVarInsn(Opcodes.ISTORE, 1);
            
            // 16 jump to 2
            mv.visitLabel(jump2);
            
            // Will loop until false
            /*
             *  2: iload_1
             *  3: iflt 19
             *  6: getstatic
             *  9: iload_1
             *  10: invokevirtual
             *  13: iinc 1, -1
             */
            mv.visitVarInsn(Opcodes.ILOAD, 1);
            mv.visitJumpInsn(Opcodes.IFLT, jump19);
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.ILOAD, 1);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);
            mv.visitIincInsn(1, -1);
            
            // Loop back up
            /*
             *  16: goto 2
             */
            mv.visitJumpInsn(Opcodes.GOTO, jump2);
            
            // 3 jump to 19
            mv.visitLabel(jump19);

            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(0,0);
            mv.visitEnd();
        }

        cw.visitEnd();

        byte[] b = cw.toByteArray();

        writeFile(b,"program7.class");
        
        System.out.println("Done!");
    }//end main
}//end class

