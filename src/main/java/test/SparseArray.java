package test;
/*
稀疏数组转换
 */
public class SparseArray
{
    public static void main(String[] args)
    {
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][4] = 2;
        System.out.println("原始二维数组");
        for(int[] row : chessArr1)
        {
            for(int data : row)
            {
                System.out.printf("%d\t",data);//格式化输出
            }
            System.out.println();
        }

        //遍历原始二维数组 得到非零数据的个数
        int sum = 0;
        for(int i=0;i<11;i++)
        {
            for(int j=0;j<11;j++)
            {
                if (chessArr1[i][j] != 0)
                    sum++;
            }
        }
        System.out.println("sum:"+sum);

        //创建稀疏数组
        int sparseArr[][] = new int[sum+1][3];

        //给稀疏矩阵赋值
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;

        //遍历二维数组，将对应的值存入稀疏数组
        int k=1;
        for(int i=0;i<11;i++)
        {
            for(int j=0;j<11;j++)
            {
                if (chessArr1[i][j] != 0)
                {
                    sparseArr[k][0] = i;
                    sparseArr[k][1] = j;
                    sparseArr[k][2] = chessArr1[i][j];
                    k++;
                }

            }
        }

        //输出稀疏数组
        System.out.println("稀疏数组输出如下");
        for(int[] row : sparseArr)
        {
            for(int data : row)
            {
                System.out.printf("%d\t",data);//格式化输出
            }
            System.out.println();
        }

        //将稀疏数组恢复成原始的二维数组
        int chessArr2[][] = new int[(sparseArr[0][0])][(sparseArr[0][1])];
        //将数据写入新的二维数组
        for (int i=1;i<=sparseArr[0][2];i++)
        {
            chessArr2[(sparseArr[i][0])][(sparseArr[i][1])] = sparseArr[i][2];
        }

        //遍历新的二维数组 得到非零数据的个数
        System.out.println("原始二维数组");
        for(int[] row : chessArr2)
        {
            for(int data : row)
            {
                System.out.printf("%d\t",data);//格式化输出
            }
            System.out.println();
        }
    }
}
