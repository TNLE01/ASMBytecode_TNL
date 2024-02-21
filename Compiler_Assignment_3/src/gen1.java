
import static utils.Utilities.writeFile;

import org.objectweb.asm.*;
import org.objectweb.asm.Opcodes;

public class gen1{
    	// Multiply two numbers (I, L, F, and D), store them, and then print each result (gen1.java,program1.class)

    public static void main(String[] args){

        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC,"program1", null, "java/lang/Object",null);
        
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

            // Declare Variables
            /*
             * 0: iconst 3
             * 1: istore 1
             * 2: iconst 2
             * 3: istore 2
             * 4: ldc2_w
             * 7: lstore 3
             * 8: ldc2_w
             * 11: lstore 5
             * 13: ldc
             * 15: fstore 7
             * 17: ldc
             * 19: fstore 8
             * 21: ldc2_w
             * 24: dstore 9
             * 26: ldc2_w
             * 29: dstore 11
             */
            // int
            mv.visitInsn(Opcodes.ICONST_3);
            mv.visitVarInsn(Opcodes.ISTORE, 1);
            mv.visitInsn(Opcodes.ICONST_2);
            mv.visitVarInsn(Opcodes.ISTORE, 2);
            // long
            mv.visitLdcInsn((Long)200l);
            mv.visitVarInsn(Opcodes.LSTORE, 3);
            mv.visitLdcInsn((Long)100l);
            mv.visitVarInsn(Opcodes.LSTORE, 5);
            // float
            mv.visitLdcInsn((Float)4.5f);
            mv.visitVarInsn(Opcodes.FSTORE, 7);
            mv.visitLdcInsn((Float)3.5f);
            mv.visitVarInsn(Opcodes.FSTORE, 8);
            // double
            mv.visitLdcInsn((Double)1.5d);
            mv.visitVarInsn(Opcodes.DSTORE, 9);
            mv.visitLdcInsn((Double)0.5d);
            mv.visitVarInsn(Opcodes.DSTORE, 11);
            
            // Multiply and store the value
            /*
             * 31: iload 1
             * 32: iload 2
             * 33: imul
             * 34: lstore 13
             * 36: lload 3
             * 37: lload 5
             * 39: lmul
             * 40: lstore 14
             * 42: fload 7
             * 44: fload 8
             * 46: fmul
             * 47: fstore 16
             * 49: dload 9
             * 51: dload 11
             * 53: dmul
             * 54: dstore 17
             */
            // int
            mv.visitVarInsn(Opcodes.ILOAD, 1);
            mv.visitVarInsn(Opcodes.ILOAD, 2);
            mv.visitInsn(Opcodes.IMUL);
            mv.visitVarInsn(Opcodes.ISTORE, 13);
            // long
            mv.visitVarInsn(Opcodes.LLOAD, 3);
            mv.visitVarInsn(Opcodes.LLOAD, 5);
            mv.visitInsn(Opcodes.LMUL);
            mv.visitVarInsn(Opcodes.LSTORE, 14);
            // float
            mv.visitVarInsn(Opcodes.FLOAD, 7);
            mv.visitVarInsn(Opcodes.FLOAD, 8);
            mv.visitInsn(Opcodes.FMUL);
            mv.visitVarInsn(Opcodes.FSTORE, 16);
            // double
            mv.visitVarInsn(Opcodes.DLOAD, 9);
            mv.visitVarInsn(Opcodes.DLOAD, 11);
            mv.visitInsn(Opcodes.DMUL);
            mv.visitVarInsn(Opcodes.DSTORE, 17);
            
            // Printing the results
            /*
             * 56: getstatic
             * 59: iload 13
             * 61: invokevirtual
             * 64: getstatic
             * 67: lload 14
             * 69: invokevirtual
             * 72: getstatic
             * 75: fload 16
             * 77: invokevirtual
             * 80: getstatic
             * 83: dload 17
             * 85: invokevirtual
             */
            // int
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.ILOAD, 13);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);
            // long
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.LLOAD, 14);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(J)V", false);
            // float
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.FLOAD, 16);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(F)V", false);
            // double
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.DLOAD, 17);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(D)V", false);

            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(0,0);
            mv.visitEnd();
        }

        cw.visitEnd();

        byte[] b = cw.toByteArray();

        writeFile(b,"program1.class");
        
        System.out.println("Done!");
    }//end main
}//end class
