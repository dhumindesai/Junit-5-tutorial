public class MathUtils {

    MathUtilsHelperService mathUtilsHelperService;

    public MathUtils(MathUtilsHelperService mathUtilsHelperService){
        this.mathUtilsHelperService = mathUtilsHelperService;
    }

    public int add(int a, int b){
        return a+b;
    }

    public double divide(int a, int b){
        return a/b;
    }

    public double calculateCircleArea(double radius){
        return Math.PI * radius * radius;
    }

    public int multiply(int a, int b) {
        return a*b;
    }

    public int perform(int a, int b){
        int result = mathUtilsHelperService.calculateResult(a,b);
        return result*2;
    }
}
