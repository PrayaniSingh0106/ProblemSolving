package leetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Dropbox {
	
	static List<Integer> repair_machine(List<List<Integer>> network, List<Integer> initial_machines) {
      
		//Integer[][] networkgraph = new int[network.size()][];
		int i=0;
		
		Integer[][] networkgraph  = network.stream()
	    .map(l -> l.stream().toArray(Integer[]::new))
	    .toArray(Integer[][]::new);
		
		int minInfected = Integer.MAX_VALUE;
        int infectedNode = 0;
        int smallIndx = Integer.MAX_VALUE;
        Set<Integer> init = new HashSet<>();
        
        for(Integer i1 :initial_machines){
            init.add(i1);
        }
        int totSpread = infectedCount(networkgraph,init);
        int savedNodes = 0;
        for(int j=0; j<initial_machines.size();j++){
            infectedNode = initial_machines.get(i);
            init.remove(infectedNode);
            
            int totInfec = infectedCount(networkgraph, init);
            savedNodes = totSpread - totInfec;
            
            if(totInfec<minInfected || minInfected==totInfec && initial_machines.get(i)<smallIndx){
                smallIndx=initial_machines.get(i);
                minInfected = totInfec;
            }
            init.add(infectedNode);
        }
		List<Integer> res = new ArrayList<Integer>();
		res.add(smallIndx);
		res.add(savedNodes);
        
		return initial_machines;
    }

	private static int infectedCount(Integer[][] networkgraph, Set<Integer> init) {
		
		 Set<Integer> bad = new HashSet<>();
	        Queue<Integer> bfs = new LinkedList<Integer>();
	        
	        for(Integer i:init)
	            bfs.add(i);
	        
	        while(!bfs.isEmpty()){
	            Integer next = bfs.remove();
	            
	            for(int i=0; i<networkgraph[next].length; i++){
	                if(networkgraph[next][i]==1 && !bad.contains(i)){
	                    bad.add(i);
	                    bfs.add(i);
	                }
	                    
	            }
	        }
	       return bad.size(); 
	}
}
