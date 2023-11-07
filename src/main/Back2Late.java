import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class Back2Late {

    /*

    private void mouseReleased(MouseEvent mouseEvent) {
        if(gameCondition[1].equals("w")){
            if(mouseEvent.getButton() == MouseButton.PRIMARY){
                for(int rank = 0; rank < 8; rank++){
                    for(int file = 0; file < 8; file++){
                        if(pawnPositions[rank][file] != null){
                            if(pawnPositions[rank][file].getBoundsInParent().contains(mouseEvent.getX(), mouseEvent.getY())){
                                toX = rank;
                                toY = file;

                                System.out.println("toX: " + toX + " toY: " + toY);
                                pawnPositions[rank][file].setOnMouseDragged(null);
                                pawnPositions[rank][file].setOnMouseReleased(null);
                                if(boardPosi[toY][toX] != boardPosi[fromX][fromY]){
                                    qRoot.getChildren().remove(pawnPositions[fromX][fromY]);
                                    //boardPosi[fromX][fromY] = 'e';
                                    pawnPositions[fromX][fromY].setX(toY * 75 + 100);
                                    pawnPositions[fromX][fromY].setY(toX * 75 + 100);
                                    ImageView img = pawnPositions[fromX][fromY];

                                    if (boardPosi[toX][toY] != 'e') {
                                        qRoot.getChildren().remove(pawnPositions[toX][toY]);
                                        pawnPositions[toX][toY] = img;
                                        qRoot.getChildren().add(pawnPositions[toX][toY]);
                                        boardPosi[toX][toY] = boardPosi[fromX][fromY];
                                        boardPosi[fromX][fromY] = 'e';
                                    } else {
                                        pawnPositions[toX][toY] = img;
                                        qRoot.getChildren().add(pawnPositions[toX][toY]);
                                        boardPosi[toX][toY] = boardPosi[fromX][fromY];
                                        boardPosi[fromX][fromY] = 'e';
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void mouseDragged(MouseEvent mouseEvent) {
        if(gameCondition[1].equals("w")){
            if(mouseEvent.getButton() == MouseButton.PRIMARY){
                for(int rank = 0; rank < 8; rank++){
                    for(int file = 0; file < 8; file++){
                        if(pawnPositions[rank][file] != null){
                            if(pawnPositions[rank][file].getBoundsInParent().contains(mouseEvent.getX(), mouseEvent.getY())){
                                pawnPositions[rank][file].setX(mouseEvent.getX() - 37.5);
                                pawnPositions[rank][file].setY(mouseEvent.getY() - 37.5);
                            }
                        }
                    }
                }
            }
        }
    }

    public void mousePressed(MouseEvent mouseEvent){
    if(gameCondition[1].equals("w")){
            if(event.getButton() == MouseButton.PRIMARY){
                for(int rank = 0; rank < 8; rank++){
                    for(int file = 0; file < 8; file++){
                        if(pawnPositions[rank][file] != null){
                            //what does getBoundsInParent() do?
                            //A

                            if(pawnPositions[rank][file].getBoundsInParent().contains(event.getX(), event.getY())){
                                fromX = rank;
                                fromY = file;
                                System.out.println("fromX: " + fromX + " fromY: " + fromY);
                                pawnPositions[rank][file].setOnMouseDragged(this::mouseDragged);
                                pawnPositions[rank][file].setOnMouseReleased(this::mouseReleased);
                            }
                        }
                    }
                }
            }
        }
    }


     */
}
