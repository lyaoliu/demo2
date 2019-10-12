package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONAware;
import com.alibaba.fastjson.JSONObject;
import io.netty.util.concurrent.GenericFutureListener;
import org.apache.http.client.methods.HttpGet;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.Timestamp;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * WebsiteTest class
 *
 * @author lyliu
 * @date 2019/05/27 18:17
 */
public class WebsiteTest {
    String key = "abcd1234";//密钥


    /**
     * 参数加密
     * @param key 秘钥
     * @param data 传入需要加密的data参数
     * @return 加密后的数据
     */
    private static String initData(String key, String data) {
        String params = "";

        try {
            if (!data.equals("")) {
                MessageDigest md = MessageDigest.getInstance("MD5");
                md.update(data.getBytes("UTF-8"));
                byte[] digestByte = md.digest();
                params = DesUtils.byteArr2HexStr(digestByte) + "@@@" + DesUtils.encrypt(data, key);

            }
            System.out.println(params);
        } catch (Exception var5) {
            var5.printStackTrace();
        }

        return params;
    }
    @Test
    public  void  test(){
        initData(key,"channelId=38a1a33d690b41f8b11f1965aec1f520&isPage=true&pageNum=1&pageSize=3");
        initData(key,"manuscriptId=568c60cc2a314038af9ea02875331989");
        String str="d510f13c0a4e64898d952ec47e71b818beb4a85f817271e77cbbc2fc95629ba230c20cf7cf900c472dc99fcd63ba1bd57d424bdc2022bd680855b13cb95a2c368a465236e0a10c7bc723228a8beae04c6b260fef0c913867f9d0a3f80c5c787422ecd0440e45cf384d8ad000b0a64b20852df457f365c5c24f2da906984d43b5f818ffa4fb3c77fe8ded251b08cfcda47c158ffdda5af04f15475e8bc96197df99100c9851e9ff88cd6f019d8b816843fbea6c9348ee33aa0019f113f8eff33b6423afa1d8d9a26d5672f6836781fdc952848bda0153a6eb5809e4d47ce86aa12a7500a7a3fd40f342fb62f3d33e949e0825abe84fe07b70ed631132fd07ce5e7c30d5e13b145eb93f9237f20c1e5509e8fff09fd92102ae9b0bb241faabc02260a89676607288ee7ddf4654d046f41d4b9f94b6c43ca313133c665abd9ad98a07764c927f10fc839e55fee79151138dd592a9585a281868cc553eea12c3401444cc1956ed36d32dede983e476ce33a471b7024edd99602f2dbcb7dda4cbb1e95009f3d107e33b0e98cce99662454495df17e6c623fff486baa5714906e5123b936807c04784a0ae2f4e63091a38332f237f89c9596a95ca90947bec08620307d111ad97c03e583e5f60d12fd2ef5f82d02c12c9f91c686e7835a51fa427ac2483923c9bd4db6d81fa283344613b658a09fc7015680abbac521d3f8c51de525c25d56c50a28e3cb181d084a9379c1d55b6e6c6e648a9f5a25cb974e05a447783b08f1a6f55be81b9a60027dadb5b38ad11581ddda3d915cfd29fc8c73b57048f665f599955d13319d541f6dd4ccaefa97a4f059d6f6a0a07d88212abb23e0434ceb4fb56a99ba86fbe107158f0af6914a532bccacd02b8bdc122ee98cdb0cf57dc9a300753ff5c6d4e86a1e924fb2108e912756c5e11ef5f77f9318d27fefbf19d876bf762bb72205246887279665bf41298f36f388105c7a5cb18102b8a334dc03f23eb5b13f0039eaab360111ba91a39a617648911a8d811e15f65f5f62974a7046dc4898565929275ba854a6736d2ac4515160e0186b3d0807b414ac33e40474f9bfa4b4b788698e16c2aaed4f07435675d467a3f6abc97df6253b71c97784542b63297aaa57d4e32215c53a75da1b55dd7a9261062b5bb427afc4bc356408d5af3e7d454da154a1ea4fd994597083ea8393f77733bfe0b4ab46f29fc63029f718f341e63c35173f42d153466338875c648b1d56278c51036754ee909eae2e2db89556a859f220fb38e73d75b6512e75fb20681e5a99dbd1c230aaad88ec8d5a3bc7c97e326926d786edc7a3f2f355560308e31a97109db63cf5f38a4afaa92ada2aee647bc061bf314e48c87d88b8a7dffee7598f46dda1f0cdd7c356910d906f81c5b54e399f61e9e50d7734160d8df491fa249676c8b8e116187bacc079dbe00fe676ede0c7629f44ed5b8b2dca6efc7345d212049fcbcd8f8fd21277d9367817f1d40ad874c5886112e6fb7e8a3a4ab5aad8f21fdd6241de06943342083c58d97f5bdeebc0b8667068eb033a58fc4f74878a8923a7aef9ade16ede1c314e0627ab9cb6b9bcd151c81f959cbeaffb7b63d9eea38eec5f41ab482e72904ad040350a29f7c5cd274a080360497bfd044779f7dc3720cd06cbc7db2f852105821aa7836a7517b9af144e4884bdfd4cf588be9058b1e4d04e4005c16f068b2b099b96c08f03b0cb54f2264ddbfc3d5b40ebcfad00c5a0b157de4b4db4d700cb5c1b3b3b80a4808e0bc1feb9bd35855cf04ac3ede298afbbaebb54012df7288ef1760a4d6e18069676b1d59b0dc6677509ae79980eb76642c86c12e0417944581d469db4ef7d7c5e7881dafe323cfb1e764c8145afd9d903151b7a920d4214f4915c03976f8a1a35be2853ac523b7349635c5b7b237bfc7da9751bf872a0c1c807675c63bfc1e7f3ab33d49740e9255728adeb0323f27a274dae1958a3c52655bc08d1b1c894146d592a9585a281868cc553eea12c3401444cc1956ed36d32d2be17ca599a97bc538a527fe56e18ca5e0ca1199cbad9b07e45766cb6ad6dbe41134093360ba2db490658b3c08b323c07bd8b9ec12408bd20d89af87a9805a6e75ad214b074a8fab33464ee12ebc393016f401f948d98a2030a74a9f4bb09d795a1bb61c75b7069bb15a82c9391d1a69ef22caffa1b78d7a31f6034448ef3f32efede250e8408fbde65e58b84315b31a9b13d17b06df04b1379a547c2e56a8c3e6f2fcf3d9e2048a11292c62b3a9a81466f9ac1f0d0788b4e1f8b94fd45c83f6de780400031a62627ce5cddc8317a8b4d6dbd85c2ca3568c1e1ff21b4ace93f4f0d6ec9a5a62aa436ce16b075a90f08f46c31f65ba13563f4ff8efaddaafe55940c91c2e6f999cbb61f9311e5845115fedf57271e54fc4a837c9b9552f72906aae415bed705ed0e11b661dd4fc9f0de4553655b984259f36e2080dc14f63402ead53bb21f3bc8e2a1f796a51c8b4670742f4e7df83dc3a7a2e29ce60d13b1240c1e074bf30a28832d48f914d6f25f6439b780eef7df85bb6ceed4dfcb871a0b0baa3f4cd882f3e55bd59989501e91f62584cbf5a2c18dfc8195dc14f8b1b5f5d12baddb2e25106e40786db5301134f861f465e5d30728048b40d93480c65b82cebc5422c7ff9502989cf41aada11994c2b76b1a9cfd3c7d9f6565e7d5b8bfe5707e989bdbd61f3bbcaa0c53dcc706649ad4e0df97065e0a90b4ab46f29fc63023930e9135cb7c9c58c5f5a9d94a93c3679f56ba5164a57af84dc4406910d6a0a05ac1433db9c022fca56f6c2d16700a3b020b1454cc7a8cb551ec5b8171dc6151c2f6ac617c49eafe2f761e1b90e8daec72054221c20b6e07bc7c4452d2da75c6d786edc7a3f2f3546546712cc4b999c434ab70fa76c82692b16836b5c32b77804a286cf32b3b7867384b73c51bef34e3ab94a2d1cb814bbc72054221c20b6e0e56d67dc6046d8123434adf00dfab0ba862b147091399bcb1d7323b20c1ac549cc217a6324e7f91db0471e88eed79faf5be367b0d30a859ee077e7d08ceb947ad48abb91040655e97e07adcce567f1f8bafddd7f0aea633a951c46b1eaab4ed00855b13cb95a2c3623793f8f420018931b8412faa8cab739550a708dc710880c";
        initReturnData(key,str);
//        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
//        System.out.println(uuid);
//        String str="{\"data\":[{\"name\":\"张三\",\"age\":12},{\"name\":\"李四\",\"age\":22}],\"id\":25}";
//        JSONObject jsonObject=JSON.parseObject(str);
//        JSONArray jsonArray= JSON.parseArray(jsonObject.getString("data"));
//        System.out.println(jsonArray);
//        System.out.println(Integer.MAX_VALUE);
//        // 585be73883766da3fb6b7de6a5151b5f
    }

    /**
     * 返回值解密
     * @param key 秘钥
     * @param data 传入请求方法后加密的数据
     * @return 解密后的返回数据
     */
    private static String initReturnData(String key, String data) {
        String str = "";

        try {
            if (!data.equals("")) {
                str = DesUtils.decrypt(replaceBlank(data), key);
            }
            System.out.println(str);
        } catch (Exception var4) {
            var4.printStackTrace();
            str = "{\"status\":false,\"msg\":\"请检查密钥是否正确！\",\"data\":\"\"}";
        }

        return str;
    }

    /**
     * 去除特殊字符
     * @param str 参数
     * @return 去除后的字符串
     */
    private static String replaceBlank(String str) {
        String dest = "";
        if (str != null) {
            Pattern p = Pattern.compile("\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }

        return dest;
    }
    @Test
     public void test2() throws InterruptedException {
         System.out.println(System.currentTimeMillis());
        ThreadPoolExecutor executor= new ThreadPoolExecutor(2,2,
                1000, TimeUnit.SECONDS,new LinkedBlockingQueue(),Executors.defaultThreadFactory());

        executor.execute( new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<=10;i++){
                    try {
                        Thread.sleep(1000);
                        System.out.println("Thread"+i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        });
        executor.shutdown();
       while (true){
           if(executor.isTerminated()){
               System.out.println("任务结束了");
               break;

           }
           Thread.sleep(1000);
       }
    }
    @Test
    public void test3(){
        Integer n=3;
        System.out.println(Integer.toBinaryString(n));
        System.out.println(n<<2);
        System.out.println(Integer.toBinaryString(n<<29));
        System.out.println(Integer.toBinaryString(n<<29).length());
        System.out.println(-1<<29 | 3);
        System.out.println(new AtomicInteger(1));
    }

    @Test
    public void test6() throws UnsupportedEncodingException {
        String a="result=25&description=�˻�Ȩ�\u07B2���";
       byte[] b= a.getBytes("gbk");
        System.out.println(new String(b,"utf-8"));
      String[] arr =  a.split("&");
      JSONObject ret=new JSONObject();
      for(int i=0;i<arr.length;i++){
          ret.put(arr[i].substring(0,arr[i].indexOf("=")),arr[i].substring(arr[i].indexOf("=")+1));
      }
        System.out.println(ret.toJSONString());
        System.out.println("0000000000".substring(0,7));
    }
    @Test
    public void test4() throws InterruptedException {
       MyTask task=new MyTask();
       Thread a=new Thread(task);
       Thread b=new Thread(task);
       a.start();
       b.start();
       a.join();
       System.out.println(task.getN());
        System.out.println(new Random().nextBoolean());
    }
    @Test
    public void test5() throws ExecutionException, InterruptedException {
//        Callable<String> callable = new Callable<String>() {
//            public String call() throws Exception {
//                System.out.println("This is ThreadPoolExetor#submit(Callable<T> task) method.");
//                Thread.sleep(10000);
//                return "result";
//            }
//        };
//
//        ExecutorService executor = Executors.newSingleThreadExecutor();
//        Future<String> future = executor.submit(callable);
//        System.out.println(future.get());
        Runnable runnable =()->{
                System.out.println("This is ThreadPoolExetor#submit(Runnable runnable) method.");
        };

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future <Integer>future = (Future<Integer>) executor.submit(runnable);
        System.out.println(future.get());
    }


}
