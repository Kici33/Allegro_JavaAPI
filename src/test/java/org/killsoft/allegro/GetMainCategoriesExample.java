package org.killsoft.allegro;

import org.killsoft.allegro.enums.Environment;
import org.killsoft.allegro.objects.Auth;
import org.killsoft.allegro.objects.Category;

public class GetMainCategoriesExample {

    public static void main(String[] args) {
        Allegro allegro = new Allegro("clientId",
                "clientSecret", Environment.PRODUCTION);


        Auth auth = allegro.authenticate();
        System.out.println(auth.getToken());
        Category[] categories = allegro.getMainCategories();

        for(Category category : categories) {
            if(category.isLeaf()) {
                System.out.println("-------");
                System.out.println("Id: " + category.getId());
                System.out.println("Name: " + category.getName());
                System.out.println("Leaf: " + category.isLeaf());
                System.out.println("-------");
            }
        }
        System.out.println("Found " + categories.length + " categories");
    }
}
