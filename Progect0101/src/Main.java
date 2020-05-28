import processing.core.*;

public class Main extends PApplet {
    static Board game = new Board();
    final int sizeOfSquare = 100;
    int textSize = sizeOfSquare / 2;
    int dSize;
    int animSquareSize;
    int animTextSize;
    int k = 0;

    public void settings() {
        fullScreen();
    }

    public void setup() {
        frameRate(14);
        dSize = 2;
        animSquareSize = 0;
        animTextSize = 1;
    }

    public void draw() {
        background(240, 240, 240);
        drawGoal();
        drawTitle();
        drawScore();
        drawBigSq();
        pushMatrix();
        translate(width / 2, height / 2);
        drawSquares();
        popMatrix();
        buttons();
        gameWindow();
    }

    public static void main(String[] args) {
        PApplet.main("Main");
    }

    void drawSquares() {

        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 4; c++) {
                int color = 14;
                int textColor = 12;
                pushMatrix();
                strokeWeight(10);
                translate((-2 + c) * sizeOfSquare + sizeOfSquare / 2, (-2 + r) * sizeOfSquare + sizeOfSquare / 2);
                rectMode(CENTER);
                switch (game.get(k, r, c)) {
                    case 0:
                        fill(207, 208, 216);
                        break;
                    case 2:
                        fill(91, 112, 124);
                        break;
                    case 4:
                        fill(64, 183, 167);
                        break;
                    case 8:
                        fill(158, 95, 6);
                        break;
                    case 16:
                        fill(187, 40, 147);
                        break;
                    case 32:
                        fill(255, 211, 0);
                        break;
                    case 64:
                        fill(0, 172, 215);
                        break;
                    case 128:
                        fill(0, 136, 81);
                        break;
                    case 256:
                        fill(255, 109, 0);
                        break;
                    case 512:
                        fill(199, 215, 0);
                        break;
                    case 1024:
                        fill(0, 67, 125);
                        break;
                    case 2048:
                        fill(243, 64, 110);
                        break;
                }
                if (!game.isRandomIndex(r, c)) {
                    rect(0, 0, sizeOfSquare, sizeOfSquare, 10);
                } else if (game.isRandomIndex(r, c) && game.moved()) {
                    rect(0, 0, animSquareSize, animSquareSize, 10);
                } else {
                    rect(0, 0, sizeOfSquare, sizeOfSquare, 10);
                }
                rectMode(CORNER);
                switch (game.get(k, r, c)) {
                    case 0:
                    case 2:
                    case 4:
                    case 8:
                    case 16:
                    case 32:
                    case 64:
                        textSize = sizeOfSquare / 2;
                        break;
                    case 128:
                        textSize = sizeOfSquare / 3;
                        break;
                    case 256:
                        textSize = sizeOfSquare / 3;
                        break;
                    case 512:
                        textSize = sizeOfSquare / 3;
                        break;
                    case 1024:
                        textSize = sizeOfSquare / 3;
                        break;
                    case 2048:
                        textSize = sizeOfSquare / 3;
                        break;
                }
                fill(207, 208, 216);
                textAlign(CENTER, CENTER);
                if (game.get(k, r, c) != 0) {
                    if (!game.isRandomIndex(r, c)) {
                        textSize(textSize);
                    } else if (game.isRandomIndex(r, c) && game.moved()) {
                        textSize(animTextSize);
                    } else {
                        textSize(textSize);
                    }
                    text(game.get(k, r, c), 0, 0);
                }
                popMatrix();
            }
        }
        if (k < 3) {
            k++;
        }
    }

    void drawGoal() {
        textSize(sizeOfSquare / 2);
        fill(91, 112, 124);
        textAlign(CENTER, BOTTOM);
        text("Goal", width / 6, height / 2);
        fill(199, 215, 0);
        textAlign(CENTER, TOP);
        text(game.getGoal(), width / 6, height / 2);
    }

    void drawTitle() {
        fill(240, 0, 0);
        textSize(40);
        text("2048", width / 2, height / 8);
        textSize(30);
  //      text("Control: arrows and +/-", width / 2, height - height / 8);
    }

    void drawScore() {
        textSize(sizeOfSquare / 2);
        textAlign(CENTER, BOTTOM);
        fill(91, 112, 124);
        text("Score:", width - width / 4, height / 2);
        fill(199, 215, 0);
        textAlign(LEFT, BOTTOM);
        text(game.getScore(), width - width / 5, height / 2);
        textAlign(CENTER, TOP);
        fill(91, 112, 124);
        text("Best:", width - width / 4, height / 2);
        fill(199, 215, 0);
        textAlign(LEFT, TOP);
        text(game.getBest(), width - width / 5, height / 2);
    }

    void drawBigSq() {
        fill(181, 184, 196);
        stroke(181, 184, 196);
        rectMode(CENTER);
        strokeWeight(12);
        rect(width / 2, height / 2, sizeOfSquare * 4, sizeOfSquare * 4, 10);
    }

    void buttons() {
        if (animSquareSize < sizeOfSquare) {
            animSquareSize += 25;
        } else if (animSquareSize == sizeOfSquare && keyPressed) {
            animSquareSize = 0;
        }
        if (animTextSize < textSize) {
            animTextSize += 25;
        } else if (animTextSize == textSize && keyPressed) {
            animTextSize = 0;
        }
        if (keyPressed) {
            if (key == '=' && key != CODED) {
                game.incGoal();
                game = new Board();
            } else if (key == '-' && key != CODED) {
                game.decGoal();
                game = new Board();
            } else if (key == CODED && keyCode == LEFT) {
                k = 0;
                game.moveLeft();
            } else if (key == CODED && keyCode == RIGHT) {
                k = 0;
                game.moveRight();
            } else if (key == CODED && keyCode == UP) {
                k = 0;
                game.moveUp();
            } else if (key == CODED && keyCode == DOWN) {
                k = 0;
                game.moveDown();
            }
        }
    }

    void gameWindow() {
        for (int k = 0; k < 4; k++) {
            for (int r = 0; r < 4; r++) {
                for (int c = 0; c < 4; c++) {
                    if (game.get(k, r, c) == game.getGoal()) {
                        fill(255, 109, 0, 40);
                        noStroke();
                        rectMode(CENTER);
                        rect(width / 2, height / 2, sizeOfSquare * 5, sizeOfSquare * 3, 10);
                        fill(240, 240, 240);
                        textSize(50);
                        text("Victory!!!", width / 2, height / 2 - height / 12);
                        textSize(25);
                        text("Press <Enter> to continue", width / 2, height / 2 + height / 12);
                        if (keyPressed && key == ENTER) {
                            game = new Board();
                        }
                    } else if (!game.moved()) {
                        fill(255, 109, 0, 40);
                        noStroke();
                        rectMode(CENTER);
                        rect(width / 2, height / 2, sizeOfSquare * 5, sizeOfSquare * 3, 10);
                        fill(240, 240, 240);
                        textSize(50);
                        text("Game Over", width / 2, height / 2 - height / 12);
                        textSize(25);
                        text("Press <Enter> to continue", width / 2, height / 2 + height / 12);
                        if (keyPressed && key == ENTER) {
                            game = new Board();
                        }
                    }
                }
            }
        }
    }
}