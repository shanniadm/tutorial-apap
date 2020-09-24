package apap.tutorial.hitungbmi.model;
import java.io.Serializable;

public class BMI {
    private final double weight; 
    private final double height;

    public BMI(final double weight, final double height){
        this.height = height;
        this.weight = weight;
    }

    public double countBMI(){
        return weight/(Math.pow((height/100), 2));
        // sebelum dihitung, convert tinggi dari cm menjadi m
    }

    public String getInterpretation(){
        final double bmi = countBMI();

        if(bmi< 18.5){
            return "Underweight";
        } else if (bmi>= 18.5 && bmi < 25){
            return "Normal";
        } else if (bmi>= 25 && bmi < 30 ){
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    public double getWeight(){
        return weight;
    }

    public double getHeight(){
        return height;
    }
}
