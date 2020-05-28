interface MyComparable{
    int compareTo(Object other);
}
interface MyComparator{
    int compare(Object left, Object right);
}

public class MyArrays {
    private MyArrays(){}
    static void sort(int[]numbers) {
        for (int i = 1; i < numbers.length; i++) {
            int current = numbers[i];
            int j = i - 1;
            while (j >= 0 && numbers[j] > current) {
                numbers[j + 1] = numbers[j];
                j--;
            }
            numbers[j + 1] = current;
        }
    }
        static void sort(Object[] numbers){
        for (int i = 1; i < numbers.length; i++){
            Object current = numbers[i];
            int j = i -1;
            while (j >= 0 && ((MyComparable)numbers[j]).compareTo(current)>0){
                numbers[j + 1] = numbers[j];
                j--;
            }
            numbers[j + 1] = current;
        }

    }
    static void sort(Object[] numbers, MyComparator comparator) {
        for (int i = 1; i < numbers.length; i++) {
            Object current = numbers[i];
            int j = i - 1;
            while (j >= 0 && comparator.compare(numbers[i], current) > 0) {
                numbers[j + 1] = numbers[j];
                j--;
            }
            numbers[j + 1] = current;
        }
    }

}
