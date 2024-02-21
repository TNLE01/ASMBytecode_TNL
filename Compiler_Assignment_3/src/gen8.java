
import static utils.Utilities.writeFile;

import org.objectweb.asm.*;
import org.objectweb.asm.Opcodes;

public class gen8{
    	// Implement If. . . Then . . . Else (gen8.java,program8.class

    public static void main(String[] args){

        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC,"program8", null, "java/lang/Object",null);
        
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
            Label jump40 = new Label();
            Label jump56 = new Label();
            Label jump64 = new Label();
            
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
            
            // Get user input for int using Scanner
            /*
             * 11: getstatic
             * 14: ldc
             * 16: invokevirtual
             * 19: aload 1
             * 20: invokevirtual
             * 23: istore 2
             */
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitLdcInsn((String)"Enter int");
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
            mv.visitVarInsn(Opcodes.ALOAD, 1);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/util/Scanner", "nextInt", "()I", false);
            mv.visitVarInsn(Opcodes.ISTORE, 2);
            
            // Conparing two ints
            /*
             * 24: iconst 1
             * 25: iload_2
             * 26: if_icmpge 40
             */
            mv.visitInsn(Opcodes.ICONST_1);
            mv.visitVarInsn(Opcodes.ILOAD, 2);
            mv.visitJumpInsn(Opcodes.IF_ICMPGE, jump40);
            
            // Print this if Scanner input is bigger than int 1
            /*
             * 29: getstatic
             * 32: ldc
             * 34: invokevirtual
             */
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitLdcInsn((String)"Greater than number 1");
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
            
            // Jump to next section
            /*
             * 37: goto 64
             */
            mv.visitJumpInsn(Opcodes.GOTO, jump64);
            
            // 26 jump to 40
            mv.visitLabel(jump40);
            
            // Conparing two ints
            /*
             * 40: iconst 1
             * 41: iload 2
             * 42: if_icmpne 56
             */
            mv.visitInsn(Opcodes.ICONST_1);
            mv.visitVarInsn(Opcodes.ILOAD, 2);
            mv.visitJumpInsn(Opcodes.IF_ICMPNE, jump56);
            
            // Print this if Scanner input is equal to int 1
            /*
             * 45: getstatic
             * 48: ldc
             * 50: invokevirtual
             */
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitLdcInsn((String)"Equal to number 1");
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
            
            // Jump to next section
            /*
             * 53: goto 64
             */
            mv.visitJumpInsn(Opcodes.GOTO, jump64);
            
            // 42 jump to 56
            mv.visitLabel(jump56);
            
            // Print this if Scanner input is less than int 1
            /*
             * 56: getstatic
             * 59: ldc
             * 61: invokevirtual
             */
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitLdcInsn((String)"Less than number 1");
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
            
            // 37, 53 jump to 64
            mv.visitLabel(jump64);

            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(0,0);
            mv.visitEnd();
        }

        cw.visitEnd();

        byte[] b = cw.toByteArray();

        writeFile(b,"program8.class");
        
        System.out.println("Done!");
    }//end main
}//end class

