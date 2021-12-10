import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class kiennk {
    public static final String patternDf = "yyyy-MM-dd";
    public static SimpleDateFormat df = new SimpleDateFormat(patternDf);

    public static void main(String[] args) {


//        List<User> list = new ArrayList<>();
//        List<Integer> list1 =new ArrayList<>();
//        HashMap<Integer,List<User>> hashMap = new HashMap<>();
//        User user1 = new User(1,3);
//        User user2 = new User(2,5);
//        User user3 = new User(3,9);
//        User user4 = new User(4,5);
//        User user5 = new User(5,3);
//        list.add(user1);
//        list.add(user2);
//        list.add(user3);
//        list.add(user4);
//        list.add(user5);
//        for(User user: list){
//            if(list1.isEmpty()){
//                list1.add(user.getUserId());
//                List<User> list2 = new ArrayList<>();
//                list2.add(user);
//                hashMap.put(user.getUserId(),list2);
//            }
//            else {
//                if(!list1.contains(user.getUserId())){
//                    list1.add(user.getUserId());
//                    List<User> list2 = new ArrayList<>();
//                    list2.add(user);
//                    hashMap.put(user.getUserId(),list2);
//                }
//                else {
//                    List<User> list2 = hashMap.get(user.getUserId());
//                    list2.add(user);
//                    hashMap.put(user.getUserId(),list2);
//                }
//            }
//        }
//        String topic ="ptkm-clone";
//        List<String> acc = Arrays.asList(topic);


//        try {
//            float a = 0.75F;
//            float b = 0.7F;
//
//            System.out.println("a kiên yêu uyên mãi mãi");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        //merge sort
//        int[] actual = { 5, 1, 35, 9, 3, 4,333,44,42,32,45 };
//        mergeSort(actual, actual.length);
//        System.out.println(actual);
//        List<User> users = Arrays.asList(new User("user 1", 12, Arrays.asList("A", "B")),
//                new User("user 2", 15, Arrays.asList("C", "D")),
//                new User("user 3", 12, Arrays.asList("E")));
//        List<String> subjects = users.stream()
//                .flatMap(user -> user.getSubjects().stream()).collect(Collectors.toList());
//        System.out.println(subjects);
//        List<String> enscriptLst = Arrays.asList("AABYAJWLZ","DDA");
// Với yêu cầu ban đầu, ta có thể sử dụng map() và distince(), phân tách các kí tự
// loại bỏ trùng lặp
//        List<String[]> a=enscriptLst.stream().map( s-> s.split("")).distinct().collect(Collectors.toList());
//        List <String> enscriptLstAfterRemoveDup = enscriptLst.stream()
//                .map(s -> s.split(""))
//                .flatMap(Arrays::stream)
//                .distinct()
//                .collect(Collectors.toList());
//        System.out.println(enscriptLstAfterRemoveDup);
       String a = "+842121";
       String b = a.substring(0,4);
       System.out.println(b);

    }


    public static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
        long diffInMillies = date2.getTime() - date1.getTime();
        return timeUnit.convert(diffInMillies, TimeUnit.MILLISECONDS);
    }

    @Override
    public String toString() {
        return "kiennk{}";
    }


    public static String deAccent(String str) {
        String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(nfdNormalizedString).replaceAll("");
    }

    public static long getTimeCheckinLate(long checkinTime, long timeEndCheckin) {
        timeEndCheckin = timeEndCheckin + 60 * 1000;

        long _time = checkinTime - timeEndCheckin;
        if (_time <= (60 * 1000)) {
            return 0;
        } else {
            long timeCounter = (_time - (60 * 1000)) / (60 * 1000);
            if (timeCounter >= 400) {
                System.out.println("debug");
            }
            return timeCounter;
        }

    }

    public static void mergeSort(int[] array, int low, int high) {
        if (high <= low) return;

        int mid = (low + high) / 2;
        mergeSort(array, low, mid);
        mergeSort(array, mid + 1, high);
        merge(array, low, mid, high);
    }

    public static void merge(int[] array, int low, int mid, int high) {
        // Creating temporary subarrays
        int leftArray[] = new int[mid - low + 1];
        int rightArray[] = new int[high - mid];

        // Copying our subarrays into temporaries
        for (int i = 0; i < leftArray.length; i++)
            leftArray[i] = array[low + i];
        for (int i = 0; i < rightArray.length; i++)
            rightArray[i] = array[mid + i + 1];

        // Iterators containing current index of temp subarrays
        int leftIndex = 0;
        int rightIndex = 0;

        // Copying from leftArray and rightArray back into array
        for (int i = low; i < high + 1; i++) {
            // If there are still uncopied elements in R and L, copy minimum of the two
            if (leftIndex < leftArray.length && rightIndex < rightArray.length) {
                if (leftArray[leftIndex] < rightArray[rightIndex]) {
                    array[i] = leftArray[leftIndex];
                    leftIndex++;
                } else {
                    array[i] = rightArray[rightIndex];
                    rightIndex++;
                }
            } else if (leftIndex < leftArray.length) {
                // If all elements have been copied from rightArray, copy rest of leftArray
                array[i] = leftArray[leftIndex];
                leftIndex++;
            } else if (rightIndex < rightArray.length) {
                // If all elements have been copied from leftArray, copy rest of rightArray
                array[i] = rightArray[rightIndex];
                rightIndex++;
            }
        }
    }

    public static void merge(
            int[] a, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k] = l[i];
                k++;
                i++;
            } else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }

    public static void mergeSort(int[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(a, l, r, mid, n - mid);
    }
}
