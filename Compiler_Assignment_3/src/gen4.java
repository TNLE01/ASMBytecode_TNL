
import static utils.Utilities.writeFile;

import java.lang.invoke.CallSite;

import org.objectweb.asm.*;
import org.objectweb.asm.Opcodes;

public class gen4{
		// Compare two numbers (I, S, L) to determine which is bigger and print it (gen4.java,program4.class)

    public static void main(String[] args){

        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC,"program4", null, "java/lang/Object",null);
        
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
            Label jump50 = new Label();
            Label jump72 = new Label();
            Label jump104 = new Label();
            Label jump127 = new Label();
            Label jump162 = new Label();
            Label jump186 = new Label();

            // Declare Variables
            /*
             *  0: iconst 3
             *  1: istore 1
             *  2: iconst 2
             *  3: istore 2
             *  4: bipush 10
             *  6: istore 3
             *  7: iconst 5
             *  8: istore 4
             *  10: ldc2_w
             *  13: lstore 5
             *  15: ldc2_w
             *  18: lstore 7
             */
            // int
            mv.visitInsn(Opcodes.ICONST_3);
            mv.visitVarInsn(Opcodes.ISTORE, 1);
            mv.visitInsn(Opcodes.ICONST_2);
            mv.visitVarInsn(Opcodes.ISTORE, 2);
            // short
            mv.visitIntInsn(Opcodes.BIPUSH, 10);
            mv.visitVarInsn(Opcodes.ISTORE, 3);
            mv.visitInsn(Opcodes.ICONST_5);
            mv.visitVarInsn(Opcodes.ISTORE, 4);
            // long
            mv.visitLdcInsn((Long)200l);
            mv.visitVarInsn(Opcodes.LSTORE, 5);
            mv.visitLdcInsn((Long)100l);
            mv.visitVarInsn(Opcodes.LSTORE, 7);

            // Conparing two ints
            /*
             * 20: iload 1
             * 21: iload 2
             * 22: if_icmple 50
             */
            mv.visitVarInsn(Opcodes.ILOAD, 1);
            mv.visitVarInsn(Opcodes.ILOAD, 2);
            mv.visitJumpInsn(Opcodes.IF_ICMPLE, jump50);
            
            // Print this if int 1 is bigger than int 2
            /*
             * 25: getstatic
             * 28: iload 1
             * 29: invokevirtual
             * 32: getstatic
             * 35: ldc
             * 37: invokevirtual
             * 40: getstatic
             * 43: iload 2
             * 44: invokevirtual
             */
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.ILOAD, 1);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "print", "(I)V", false);
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitLdcInsn((String)" is bigger than ");
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "print", "(Ljava/lang/String;)V", false);
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.ILOAD, 2);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);

            // Jump to next section
            /*
             * 47: goto 72
             */
            mv.visitJumpInsn(Opcodes.GOTO, jump72);
            
            // 22 jump to 50
            mv.visitLabel(jump50);
            
            // Print this if int 2 is bigger than int 1
            /*
             * 50: getstatic
             * 53: iload 2
             * 54: invokevirtual
             * 57: getstatic
             * 60: ldc
             * 62: invokevirtual
             * 65: getstatic
             * 68: iload 1
             * 69: invokevirtual
             */ 
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.ILOAD, 2);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "print", "(I)V", false);
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitLdcInsn((String)" is bigger than ");
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "print", "(Ljava/lang/String;)V", false);
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.ILOAD, 1);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);

            // 47 jump to 72
            mv.visitLabel(jump72);

            // Comparing two shorts
            /*
             * 72: iload 3
             * 73: iload 4
             * 75: if_icmple 104
             */
            mv.visitVarInsn(Opcodes.ILOAD, 3);
            mv.visitVarInsn(Opcodes.ILOAD, 4);
            mv.visitJumpInsn(Opcodes.IF_ICMPLE, jump104);
            
            // Print this if short 1 is bigger than short 2
            /*
             * 78: getstatic
             * 81: iload 3
             * 82: invokevirtual
             * 85: getstatic 
             * 88: ldc
             * 90: invokevirtual
             * 93: getstatic
             * 96: iload 4
             * 98: invokevirtual
             */
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.ILOAD, 3);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "print", "(I)V", false);
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitLdcInsn((String)" is bigger than ");
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "print", "(Ljava/lang/String;)V", false);
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.ILOAD, 4);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);
            
            // Jump to next section
            /*
             * 101: goto 127
             */
            mv.visitJumpInsn(Opcodes.GOTO, jump127);

            // 75 jump to 104
            mv.visitLabel(jump104);
            
            // Print this if short 2 is bigger than short 1
            /*
             * 104: getstatic
             * 107: iload 4
             * 109: invokevirtual
             * 112: getstatic
             * 115: ldc
             * 117: invokevirtual
             * 120: getstatic
             * 123: iload 3
             * 124: invokevirtual
             */
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.ILOAD, 4);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "print", "(I)V", false);
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitLdcInsn((String)" is bigger than ");
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "print", "(Ljava/lang/String;)V", false);
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.ILOAD, 3);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);

            // 101 jump to 127
            mv.visitLabel(jump127);

            // Comparing two longs
            /*
             * 127: lload 5
             * 129: lload 7
             * 131: lcmp
             * 132: ifle 162
             */
            mv.visitVarInsn(Opcodes.LLOAD, 5);
            mv.visitVarInsn(Opcodes.LLOAD, 7);
            mv.visitInsn(Opcodes.LCMP);
            mv.visitJumpInsn(Opcodes.IFLE, jump162);
            
            // Print this if long 1 is bigger than long 2
            /*
             * 135: getstatic
             * 138: lload 5
             * 140: invokevirtual
             * 143: getstatic
             * 146: ldc
             * 148: invokevirtual
             * 151: getstatic
             * 154: lload 7
             * 156: invokevirtual
             */
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.LLOAD, 5);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "print", "(J)V", false);
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitLdcInsn((String)" is bigger than ");
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "print", "(Ljava/lang/String;)V", false);
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.LLOAD, 7);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(J)V", false);
            
            // Jump to next section
            /*
             * 159: goto 186
             */
            mv.visitJumpInsn(Opcodes.GOTO, jump186);

            // 132 jump to 162
            mv.visitLabel(jump162);
            
            // Print this if long 2 is bigger than long 1
            /*
             * 162: getstatic
             * 165: lload 7
             * 167: invokevirtual
             * 170: getstatic
             * 173: ldc
             * 175: invokevirtual
             * 178: getstatic
             * 181: lload 5
             * 183: invokevirtual
             */
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.LLOAD, 7);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "print", "(J)V", false);
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitLdcInsn((String)" is bigger than ");
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "print", "(Ljava/lang/String;)V", false);
            mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitVarInsn(Opcodes.LLOAD, 5);
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(J)V", false);
            
            // 159 jump to 186
            mv.visitLabel(jump186);
            
            mv.visitInsn(Opcodes.RETURN);
            mv.visitMaxs(0,0);
            mv.visitEnd();
        }

        cw.visitEnd();

        byte[] b = cw.toByteArray();

        writeFile(b,"program4.class");
        
        System.out.println("Done!");
    }//end main
}//end class
