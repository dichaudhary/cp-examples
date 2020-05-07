package practice.cp.fun;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import practice.cp.fun.dp.KnapsackNoRepetition;
import practice.cp.fun.sort.QuickSort;
import java.util.Arrays;
import java.util.Date;
import java.util.stream.Collectors;

@RestController
public class HelloController {
    @GetMapping("/api/hello")
    public String hello() {
        return "Hello, the time at the server is now " + new Date() + "\n";
    }

    @RequestMapping(value = "/api/knapsacknorepetition", method= RequestMethod.POST, produces = "application/json; charset=UTF-8", consumes = "application/json; charset=UTF-8")
    @ResponseBody
    public String hello(@RequestBody KnapsackPOJO knapsackPOJO) {
        return String.valueOf(solveKnapsack(knapsackPOJO.getProfit(), knapsackPOJO.getWeight(), knapsackPOJO.getCapacity()));
    }

    @RequestMapping(value = "/api/quicksort", method= RequestMethod.POST, produces = "application/json; charset=UTF-8", consumes = "application/json; charset=UTF-8")
    @ResponseBody
    public String hello(@RequestBody QuicksortPojo quickSort) {
        return String.valueOf(solveQuickSort(quickSort.getUnsortedArray()));
    }

    private String solveQuickSort(String unsortedArray) {
        int[] unsortedNumbers = Arrays.stream(unsortedArray.split(" ")).mapToInt(Integer::parseInt).toArray();
        QuickSort quicksort = new QuickSort();
        quicksort.quicksort(unsortedNumbers, 0, unsortedNumbers.length -1);
        return Arrays.toString(unsortedNumbers);
    }

    private static int solveKnapsack(String profit, String weight, String capacity) {
        int[] profitnumbers = Arrays.stream(profit.split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] weightnumbers = Arrays.stream(weight.split(" ")).mapToInt(Integer::parseInt).toArray();
        int capacityNumber = Integer.parseInt(capacity);
        String[] profits = profit.split(" ");
        Arrays.stream(profits).map(value-> {
            return Integer.valueOf(value);
        }).collect(Collectors.toList());
        KnapsackNoRepetition knapsackNoRepetition = new KnapsackNoRepetition(weightnumbers, profitnumbers, capacityNumber);
        return knapsackNoRepetition.solveKnapsack();
    }
}
