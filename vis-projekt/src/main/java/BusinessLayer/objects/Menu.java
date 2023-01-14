package BusinessLayer.objects;

public class Menu
{
    private int id_menu;
    private String breakfast;
    private String snack_1;
    private String lunch;
    private String snack_2;
    private String dinner;
    private int calories;
    private int carbohydrate;
    private int fat;
    private int protein;
    private int sugar;
    private int salt;
    private int fiber;

    public Menu(int id_menu,String breakfast, String snack_1,String lunch, String snack_2, String dinner, int calories, int carbohydrate, int fat, int protein, int sugar, int salt, int fiber)
    {
        this.id_menu = id_menu;
        this.breakfast = breakfast;
        this.snack_1 = snack_1;
        this. lunch = lunch;
        this. snack_2 = snack_2;
        this. dinner = dinner;
        this. calories = calories;
        this. carbohydrate = carbohydrate;
        this. fat = fat;
        this.protein = protein;
        this. sugar = sugar;
        this.salt = salt;
        this.fiber = fiber;
    }
    
    public int getID() {return this.id_menu;}
    public String getBreakfast() {return this.breakfast;}
    public String getSnack_1() {return this.snack_1;}
    public String getLunch() {return this.lunch;}
    public String getSnack_2() {return this.snack_2;}
    public String getDinner() {return this.dinner;}
    public int getCalories() {return this.calories;}
    public int getCarbohydrate() {return this.carbohydrate;}
    public int getFat() {return this.fat;}
    public int getProtein() {return this.protein;}
    public int getSugar() {return this.sugar;}
    public int getSalt() {return this.salt;}
    public int getFiber() {return this.fiber;}
   
}
