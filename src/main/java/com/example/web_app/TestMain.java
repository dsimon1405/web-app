//package com.example.web_app;
//
//import java.io.IOException;
//import java.net.HttpURLConnection;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.util.ArrayList;
//import java.util.List;
//
//public class TestMain {
//
//    static public void main(String[] args) throws IOException {
////        List<Thread> ths = new ArrayList<>();
////        for (int i = 0; i < 5; ++i) {
////            int finalI = i;
////            ths.add(new Thread(() -> {
////                int count_200 = 0;
////                System.out.println("started " + finalI);
////                try {
////                    URL url = new URL("http://127.0.0.1:64728/web-app/all");
////                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
////                    con.setRequestMethod("GET");
////                    for (int j = 0; j < 10; ++j) {
////                        if (con.getResponseCode() == 200) ++count_200;
////                    }
////                } catch (IOException e) {
////                    throw new RuntimeException(e);
////                }
////
////                System.out.println(finalI + " done. 200 count = " + count_200);
////            }));
////        }
////        ths.forEach(th -> {
////            try {
////                th.join();
////            } catch (InterruptedException e) {
////                throw new RuntimeException(e);
////            }
////        });
//
//
//
//
//        try {
//            for (int j = 0; j < 10; ++j) {
//                URL url = new URL("http://127.0.0.1:64728/web-app/all");
//                HttpURLConnection con = (HttpURLConnection) url.openConnection();
//                con.setRequestMethod("GET");
//                con.getResponseCode();
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
