package guibasic1;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FacesAWT {

    public static void main(String[] args) {
        new FacesAWT();
    }

    FacesAWT() {
        FaceFrame f = new FaceFrame();
        f.setSize(800, 800);
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        f.setVisible(true);
    }

    class FaceFrame extends Frame {
        FaceObj[][] faces;

        FaceFrame() {
            faces = new FaceObj[3][3];
            int size = 200;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    faces[i][j] = new FaceObj(50 + j * (size + 10), 50 + i * (size + 10), size, size);
                    faces[i][j].setEmotionLevel(i,j);
                }
            }
        }

        public void paint(Graphics g) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    faces[i][j].drawFace(g);
                }
            }
        }
    }

    private class FaceObj {
        int xStart;
        int yStart;
        int width;
        int height;
        int emotioneye;
        int emotionnose;
        int emotionLevel;

        FaceObj(int x, int y, int w, int h) {
            this.xStart = x;
            this.yStart = y;
            this.width = w;
            this.height = h;
        }

        public void setEmotionLevel(int i,int j) {
            this.emotionLevel = i;
            this.emotioneye = j + 3 + j * 20;
            this.emotionnose = j * 25;

        }

        void drawFace(Graphics g) {
            drawRim(g);
            drawEyes(g);
            drawBrow(g);
            drawNose(g);
            drawMouth(g);
        }

        void drawRim(Graphics g) {
            g.drawRect(xStart, yStart, width, height);
            g.setColor(Color.CYAN);
            g.fillRect(xStart + 1, yStart + 1, width - 1, height - 1);
            g.setColor(Color.BLACK);
        }

        void drawBrow(Graphics g) {
            int wx1 = xStart + width * 1 / 8;
            int wx2 = xStart + width * 1 / 2;
            int wy = yStart + height / 5;
            
            if (emotionLevel == 0) {
                g.drawLine(wx1 + width * 1 / 8, wy - 10, xStart + width * 4 / 8, wy);
                g.drawLine(wx1 + width * 1 / 8, wy + 10, xStart + width * 4 / 8, wy);
                g.drawLine(wx2 + width * 1 / 8, wy - 10, xStart + width * 7 / 8, wy);
                g.drawLine(wx2 + width * 1 / 8, wy + 10, xStart + width * 7 / 8, wy);
            } else if (emotionLevel == 1) {
                g.drawLine(wx1 + width * 1 / 8, wy, xStart + width * 4 / 8, wy);
                g.drawLine(wx2 + width * 1 / 8, wy, xStart + width * 7 / 8, wy);
            } else if (emotionLevel == 2) {
                g.drawLine(wx1 + width * 1 / 8, wy + 10, xStart + width * 4 / 8, wy);
                g.drawLine(wx2 + width * 1 / 8, wy + 10, xStart + width * 7 / 8, wy);
            }
        }

        void drawEyes(Graphics g) {
            int r = this.emotioneye;
            g.drawOval(xStart + 45, yStart + 65, r, r);
            g.drawOval(xStart + width - 45 - r, yStart + 65, r, r);
        }

        void drawNose(Graphics g) {
            int nx = this.emotionnose;
            int xMiddle = xStart + width / 2;
            int yMiddle = yStart + height / 2;
            g.drawRect(xMiddle, yMiddle, 5,nx);
        }

        void drawMouth(Graphics g) {
            int mx = 100;
            int xMiddle = xStart + width / 2;
            int yMiddle = yStart + height - 30;
            
            if (emotionLevel == 0) {
                g.drawArc(xMiddle - mx / 2, yMiddle - 20, mx, 40, 0, -180);
                g.drawLine(xMiddle - mx / 2, yMiddle, xMiddle + mx / 2, yMiddle);
            } else if (emotionLevel == 1) {
                g.drawLine(xMiddle - mx / 2, yMiddle, xMiddle + mx / 2, yMiddle);
            } else if (emotionLevel == 2) {
                g.drawArc(xMiddle - mx / 2, yMiddle - 10, mx, 40, 0, 180);
            }
        }
    }
}
