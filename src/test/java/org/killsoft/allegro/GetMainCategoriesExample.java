package org.killsoft.allegro;

import org.killsoft.allegro.enums.Environment;
import org.killsoft.allegro.objects.Auth;
import org.killsoft.allegro.objects.Category;

public class GetMainCategoriesExample {

    public static void main(String[] args) {
        Allegro allegro = new Allegro("ffdbce6145624c23a89db2d97de158ec",
                "sooMd2ILo6e5G4LL1apc3n7XipyRLbgw1DloQ2vRyJvoHyXqwR0JVTeHVBBVfygo", Environment.PRODUCTION);

//        Allegro allegro = new Allegro("c1a53ecb34044d269a4280c8c3c01aaf",
//                "Tsbn3boWSOa2iLXq1ZkOlPwB5w8umPCNVOOP011GZnVUgRjV9MyqXJld2mCFGsjb", Environment.SANDBOX);

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
