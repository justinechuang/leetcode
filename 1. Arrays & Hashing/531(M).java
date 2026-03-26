//531. Loneley Pixel I (Medium)
class Solution {
    public int findLonelyPixel(char[][] picture) {
        int count = 0;
        for(int i=0; i<picture.length; i++){
            for(int j=0; j<picture[0].length; j++){
                if(picture[i][j] == 'B'){
                    if(check(i, j, picture)){
                        count++;
                    }
                }
            }
        }
        return count;
    }
    public boolean check(int i, int j, char[][] picture){
        //check up
        int colCount = 0; 
        for(int m = 0; m<picture.length; m++){
            if(picture[m][j] == 'B'){
                colCount++;
                if(colCount > 1) return false;
            }
        }   
        int rowCount = 0;
        //check down
        for(int n = 0; n<picture[0].length; n++){
            if(picture[i][n] == 'B'){
                rowCount++;
                if(rowCount > 1) return false;
            }
        }
        return true; 
    }
}