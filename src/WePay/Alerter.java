package WePay;
import java.util.List;


public class Alerter {

	// Complete the alert function below.
	static boolean alert(List<Integer> inputs, int windowSize, float allowedIncrease) {

	        float allowedAvg = 0;
	        int maxVal = Integer.MIN_VALUE;
	        int sum = 0;

	        for(int i=0; i<windowSize;i++){
	            sum+=inputs.get(i);
	            if(inputs.get(i)>maxVal)
	            maxVal = inputs.get(i);
	        }
	        allowedAvg = sum/windowSize ;
	       
	        if(allowedAvg * allowedIncrease < maxVal)
	        return true;

	        float prevAllowedAvg = allowedAvg;
	        System.out.println("prevAllowedAvg : " + prevAllowedAvg);
	        maxVal = Integer.MIN_VALUE;
	        
	        for(int i = windowSize; i< inputs.size(); i++){
	            sum = sum + inputs.get(i) - inputs.get(i - windowSize);
	           
	            allowedAvg = sum / windowSize;

	           float secCondition = prevAllowedAvg * allowedIncrease;
	            
	            if (maxVal > allowedAvg * allowedIncrease || allowedAvg > secCondition)
	                return true;
	           
	            if(inputs.get(i)>maxVal)
	                maxVal = inputs.get(i);

	            if(allowedAvg < prevAllowedAvg)
	            prevAllowedAvg = allowedAvg;
	        }

	    return false;
	    }

}
