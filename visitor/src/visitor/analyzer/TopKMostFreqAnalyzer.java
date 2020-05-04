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
import visitor.results.TopKFreqWordsResults;

public class TopKMostFreqAnalyzer implements Visitor {
	private int maxSize;
	private Results topKFreqWordsResults;

	public TopKMostFreqAnalyzer(int kIn, Results topKFreqWordsResultsIn) {
		this.maxSize = kIn;
		this.topKFreqWordsResults = topKFreqWordsResultsIn;
	}

	@Override
	public void visit(Element visitor) {

		MyArrayList myArrayList = (MyArrayList) visitor;
		TopKFreqWordsResults spellCheckResults = (TopKFreqWordsResults) this.topKFreqWordsResults;
		//System.out.println("in TopKMostFreqAnalyzer");
		Iterator iterator = myArrayList.createIterator();
		while (iterator.hasNext()) {
			List<String> words = new ArrayList<String>();
			String temp = (String) iterator.next();
			String keys[] = temp.toLowerCase().split(" ");
			{

				HashMap<String, Integer> map = new HashMap<>();
				List<String> wordList = new ArrayList<>();

				for (String key : keys) {

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

					wordList.add(priorityQueue.poll().getKey());
				}

				for (int i = wordList.size() - 1; i >= 0; i--) {
					words.add(wordList.get(i));
				}
				spellCheckResults.storeWords(words);

			}

		}

	}

	@Override
	public String toString() {
		return "TopKMostFreqAnalyzer [maxSize=" + maxSize + ", topKFreqWordsResults=" + topKFreqWordsResults + "]";
	}

}
