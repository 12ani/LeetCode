import java.util.*; 

public class Solution1122 {
	
	public static void main(String[] args) {
		
		int[] arr1 = new int[]{2,3,1,3,2,4,6,7,9,2,19,19,7};
		int[] arr2 = new int[]{2,1,4,3,9,6}; 
		
		System.out.println(Arrays.toString(relativeSortArray(arr1, arr2)));
		
		
		
		
	}
	
	public static int[] relativeSortArray(int[] arr1, int[] arr2) {

        Map<Integer, Integer> map = new HashMap<>(); 
        Set<Integer> set = new HashSet<>(); 
        List<Integer> list = new ArrayList<>(); 
        int[] result = new int[arr1.length]; 
        
        for(int i1 : arr1){
            map.put(i1, map.getOrDefault(i1, 0) + 1); 
        }
        for(int i2 : arr1){
            set.add(i2);
        }
        
        int i =0; 
    
            
            for(int s : arr2){
                if(map.containsKey(s)){
                    int count = map.get(s); 
                    while(count != 0){
                        result[i] = s; 
                        i++; 
                        count--; 
                    }
                    map.remove(s); 
                }
            }
    
      
        for(int l : map.keySet()){
            
            int c = map.get(l);
            while(c !=0 ){
                 list.add(l); 
                c--; 
            }
          
           
        }
        Collections.sort(list);
        
        for(int r : list){
            result[i] = r; 
            i++; 
        }
        
        return result; 
        
    }
}
	

