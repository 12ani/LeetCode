import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

	public static class ProductReviewScore {
		int productId;
		double reviewScore;
		
		public ProductReviewScore(int p, double r) {
			this.productId = p;
			this.reviewScore = r;
		}
	}

	public static Map<Integer, Double> productReview(int scoreCount, List<ProductReviewScore> reviewScoresOfProduct) {
		   
		   Map<Integer, ArrayList<Double>> productReviewLookupTable = new HashMap<>();
		   for(int i=0;i<scoreCount;i++){
		       if(productReviewLookupTable.containsKey(reviewScoresOfProduct.get(i).productId)){
		           ArrayList<Double> reviewScoreList=productReviewLookupTable.get(reviewScoresOfProduct.get(i).productId);
		           reviewScoreList.add(reviewScoresOfProduct.get(i).reviewScore);
		           Collections.sort(reviewScoreList,Collections.reverseOrder());
		       } else{
		           ArrayList<Double> reviewScoreList=new ArrayList<>();
		           reviewScoreList.add(reviewScoresOfProduct.get(i).reviewScore);
		           productReviewLookupTable.put(reviewScoresOfProduct.get(i).productId,reviewScoreList);
		       }
		   }

		   Map<Integer,Double> aggregateScoreMap=new HashMap<>();
		   for(Map.Entry<Integer,ArrayList<Double>> entry: productReviewLookupTable.entrySet()){
		       double scoreAvg;
		       double sum=0.0;
		       ArrayList<Double> scores=entry.getValue();
		       
		       double sz = scores.size() > 5.0 ? 5.0 : scores.size();
		       
		       for(int i=0;i<sz;i++){
		           sum+=scores.get(i);
		       }
		       scoreAvg=sum/sz;
		       System.out.println("scoreAvg = " + scoreAvg);
		       aggregateScoreMap.put(entry.getKey(),scoreAvg);
		   }
		   return aggregateScoreMap;
	}

	public static void main(String[] args) {
		int scoreCount = 15;
		
		List<ProductReviewScore> list = new ArrayList<>();
		ProductReviewScore pr = new ProductReviewScore(1, 10.0);
		ProductReviewScore pr1 = new ProductReviewScore(1, 20.0);
		ProductReviewScore pr2 = new ProductReviewScore(1, 30.0);
		ProductReviewScore pr3 = new ProductReviewScore(1, 40.0);
		ProductReviewScore pr4 = new ProductReviewScore(1, 50.0);
		ProductReviewScore pr5 = new ProductReviewScore(1, 60.0);
		ProductReviewScore pr6 = new ProductReviewScore(2, 30.0);
		ProductReviewScore pr7 = new ProductReviewScore(2, 20.0);
		ProductReviewScore pr8 = new ProductReviewScore(2, 10.0);
		ProductReviewScore pr9 = new ProductReviewScore(3, 100.0);
		ProductReviewScore pr10 = new ProductReviewScore(3, 200.0);
		ProductReviewScore pr11 = new ProductReviewScore(3, 300.0);
		ProductReviewScore pr12 = new ProductReviewScore(3, 40.0);
		ProductReviewScore pr13 = new ProductReviewScore(3, 80.0);
		ProductReviewScore pr14 = new ProductReviewScore(3, 10.0);
		list.add(pr);
		list.add(pr1);
		list.add(pr2);
		list.add(pr3);
		list.add(pr4);
		list.add(pr5);
		list.add(pr6);
		list.add(pr7);
		list.add(pr8);
		list.add(pr9);
		list.add(pr10);
		list.add(pr11);
		list.add(pr12);
		list.add(pr13);
		list.add(pr14);
		
		System.out.println("Printing the result -- ");
		productReview(15, list);
		
	}

}
