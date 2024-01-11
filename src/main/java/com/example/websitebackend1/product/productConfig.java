package com.example.websitebackend1.product;

import org.hibernate.tool.schema.spi.CommandAcceptanceException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class productConfig {

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository repository){
        return args -> {

            Product iphone3000 = new Product(
                    1L,
                    "iPhone3000",
                    "1000",
                    "https://store.storeimages.cdn-apple.com/4668/as-images.apple.com/is/refurb-iphone-13-pro-max-blue-2023?wid=1144&hei=1144&fmt=jpeg&qlt=90&.v=1679072989205",
                    "A normal phone for a huge price!",
                    "10"
            );

            Product samsungs9 = new Product(
                    "samsung S9",
                    "999",
                    "https://www.refurbished.nl/cache/images/refurbished-samsung-galaxy-s9-blauw_600x600_BGresize_16777215-tj.png",
                    "A phone battery with extra spice!",
                    "100"
            );


            Product product1 = new Product(
                    "iPhone 13",
                    "1299",
                    "https://media.s-bol.com/qoYrXNqZvjlk/yOXoqg/550x748.jpg",
                    "A phone with a powerful processor and a stunning camera!",
                    "100"
            );

            Product product2 = new Product(
                    "Samsung Galaxy S21",
                    "799",
                    "https://www.proshop.nl/Images/915x900/3075890_03ab3ca07cc8.jpg",
                    "A phone with a sleek design and a long-lasting battery!",
                    "100"
            );

            Product product3 = new Product(
                    "Google Pixel 6",
                    "899",
                    "https://mobiel-product.imgix.net/6lxujv5t11uiw36f5xbmqnpd8cnt?w=540&h=540&trim=none&auto=compress%2Cformat",
                    "A phone with a powerful camera and a smooth display!",
                    "100"
            );

            Product product4 = new Product(
                    "Bread",
                    "5",
                    "https://www.cobsbread.com/wp-content/uploads/2022/05/cobs-product-whole-wheat-loaf-1-583x400-1.png",
                    "A loaf of bread! A loaf of bread! A loaf of bread! A loaf of bread! A loaf of bread! A loaf of bread!",
                    "100"
            );

            Product product5 = new Product(
                    "Xiaomi Mi 11",
                    "799",
                    "https://i01.appmifile.com/v1/MI_18455B3E4DA706226CF7535A58E875F0267/pms_1612534096.43534460.png",
                    "A phone with a powerful processor and a high-quality camera!",
                    "100"
            );

            Product product6 = new Product(
                    "Sony Xperia 1 III",
                    "1299",
                    "https://s.yimg.com/uu/api/res/1.2/DTqH_MN81e7qsLXxmCBA0Q--~B/aD0xMzMzO3c9MjAwMDthcHBpZD15dGFjaHlvbg--/https://media-mbst-pub-ue1.s3.amazonaws.com/creatr-uploaded-images/2021-10/090a8392-35a6-11ec-bff3-6b4ccfe82283.cf.jpg",
                    "A phone with a 4K OLED display and a triple camera system!",
                    "100"
            );

            Product product7 = new Product(
                    "Motorola Edge 20 Pro",
                    "699",
                    "https://www.androidauthority.com/wp-content/uploads/2021/10/Moto-Edge-20-Pro-back-of-the-phone-in-hand-outdoors.jpg",
                    "A phone with a 144Hz display and a powerful processor!",
                    "100"
            );

            Product product8 = new Product(
                    "Nokia 3310",
                    "20",
                    "https://i.ebayimg.com/images/g/pTwAAOSw4ytjAe-K/s-l1600.jpg",
                    "A phone with a large battery and a high-quality camera!",
                    "100"
            );

            Product product9 = new Product(
                    "Asus ROG Phone 5",
                    "999",
                    "https://m.media-amazon.com/images/I/51v4pHYUKCS._AC_UF1000,1000_QL80_.jpg",
                    "A phone with a 144Hz display and a powerful processor!",
                    "100"
            );

            Product product10 = new Product(
                    "Realme GT",
                    "599",
                    "https://www.backmarket.nl/cdn-cgi/image/format%3Dauto%2Cquality%3D75%2Cwidth%3D260/https://d2e6ccujb3mkqf.cloudfront.net/d6ab913a-5b9e-4bd6-8060-5a5634b8f119-1_3dc22ada-7ffd-4698-bdb6-90a037d2b7cf.jpg",
                    "A phone with a powerful processor and a high-quality camera!",
                    "100"
            );


            repository.saveAll(
                    List.of(iphone3000, samsungs9, product1, product2, product3, product4, product5, product6, product7, product8, product9, product10)
            );

        };
    }
}
