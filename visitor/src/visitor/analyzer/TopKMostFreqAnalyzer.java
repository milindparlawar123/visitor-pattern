package visitor.analyzer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import visitor.myArrayList.Element;
import visitor.myArrayList.MyArrayList;
import visitor.results.Results;

public class TopKMostFreqAnalyzer implements Visitor {
	private int maxSize;
	private Results topKFreqWordsResults;
	private List<List<String>> data = new ArrayList<List<String>>();

	public TopKMostFreqAnalyzer(int kIn, Results topKFreqWordsResultsIn) {
		// TODO Auto-generated constructor stub
		this.maxSize = kIn;
		this.topKFreqWordsResults = topKFreqWordsResultsIn;
	}

	@Override
	public void visit(Element visitor) {

		MyArrayList myArrayList = (MyArrayList) visitor;

		System.out.println("in TopKMostFreqAnalyzer");
		Iterator iterator = myArrayList.createIterator();
		while (iterator.hasNext()) {
			List<String> words = new ArrayList<String>();
			String temp = (String) iterator.next();
			String keys[] = temp.toLowerCase().split(" ");
			{
				// count the frequency for each element
				HashMap<String, Integer> map = new HashMap<>();
				List<String> result = new ArrayList<>();
				
				for (String key : keys) {
					// map.put(num, map.getOrDefault(num, 0) + 1);
					map.put(key, (map.get(key) != null ? map.get(key) : 0) + 1);
				}

				PriorityQueue<Map.Entry<String, Integer>> priorityQueue = new PriorityQueue<>(
						Comparator.comparing(word -> word.getValue()));

				for (Map.Entry<String, Integer> keyValue : map.entrySet()) {
					
					priorityQueue.offer(keyValue);
					if (priorityQueue.size() > maxSize) {
						priorityQueue.poll();
					}
				}

				
				while (priorityQueue.size() > 0) {
					
					result.add(priorityQueue.poll().getKey());
				}

				for (int i = result.size() - 1; i >= 0; i--) {
					words.add(result.get(i));
				}
				// Collections.reverse(result);
				// System.out.println("words >> " + words);
				data.add(words);
				// System.out.println(result + " " + result.size());

			}

		}
		System.out.println(data);
		// TODO Auto-generated method stub

	}

}
