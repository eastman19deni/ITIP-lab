public class ArrayAverage {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int sum = 0;
        double average = 0;
        
        //обработка исключений 
        try {

          //проверка на нулл
            if (arr == null) {
                throw new NullPointerException("Массив не инициализирован (null)");
            }
            
            //проверка на пустой массив 
            if (arr.length == 0) {
                throw new ArithmeticException("Массив пустой, невозможно вычислить среднее значение");
            }
            

            //вычисление суммы 
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i];
            }
            

            //вычисление среднего значения
            average = (double) sum / arr.length;
            

            //вывод массива
            System.out.print("Массив: [");
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i]);
                if (i < arr.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
            

            System.out.println("Сумма элементов: " + sum);
            System.out.println("Количество элементов: " + arr.length);
            System.out.println("Среднее арифметическое: " + average);
            
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка: Выход за границы массива");
            System.out.println("Сообщение об ошибке: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Ошибка: " + e.getMessage());
            System.out.println("Проверьте инициализацию массива");
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: " + e.getMessage());
            System.out.println("Массив должен содержать хотя бы один элемент");
        } catch (Exception e) {
            System.out.println("Произошла непредвиденная ошибка: " + e.getMessage());
        }
    }
}
