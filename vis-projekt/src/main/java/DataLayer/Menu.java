package DataLayer;

public class Menu
{

    int id_menu;
    String breakfast;
    String snack_1;
    String lunch;
    String snack_2;
    String dinner;
    int calories;
    int carbohydrate;
    int fat;
    int protein;
    int sugar;
    int salt;
    int fiber;


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

    public void printMenu()
    {
        System.out.print("ID_Menu:   ");
        System.out.println(id_menu);
        System.out.print("breakfast:   ");
        System.out.println(breakfast);
        System.out.print("snack_1:   ");
        System.out.println(snack_1);
        System.out.print("lunch:   ");
        System.out.println(lunch);
        System.out.print("snack_2:   ");
        System.out.println(snack_2);
        System.out.print("dinner:   ");
        System.out.println(dinner);
        System.out.print("calories:   ");
        System.out.println(calories);
        System.out.print("carbohydrate:   ");
        System.out.println(carbohydrate);
        System.out.print("fat:   ");
        System.out.println(fat);
        System.out.print("protein:   ");
        System.out.println(protein);
        System.out.print("sugar:   ");
        System.out.println(sugar);
        System.out.print("salt:   ");
        System.out.println(salt);
        System.out.print("fiber:   ");
        System.out.println(fiber);
    }


}
