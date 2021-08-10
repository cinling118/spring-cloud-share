package com.cloud.web.io;



import org.apache.commons.collections.bag.SynchronizedSortedBag;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: 读取两个文件中相同的单词写到另一个文件中
 */
public class TestReadComWords {

    /**
     * @Description: 使用FileInputStream
    */
    public static String getFileContent(String filePath){
        InputStreamReader reader = null;
        BufferedReader bufferedReader = null;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            File file = new File(filePath);
            if (file.exists() && file.isFile()) {
                reader = new InputStreamReader(new FileInputStream(file),"UTF-8");
                bufferedReader = new BufferedReader(reader);
                String lineText = null;
                while ((lineText = bufferedReader.readLine()) != null) {
                    stringBuffer.append(lineText).append("\n");
                }
                reader.close();
                bufferedReader.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                    reader = null;
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                    bufferedReader = null;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return stringBuffer.toString();
    }

    /**
     * @Description: 使用FileReader
     * @date 2021/8/9 17:45
    */
    public static String getFileContent2(String filePath){
        StringBuffer stringBuffer = new StringBuffer();
        BufferedReader bufferedReader = null;
        FileReader reader = null;
        try {
            reader = new FileReader(filePath);
            bufferedReader = new BufferedReader(reader);
            String lineText = null;
            while ((lineText = bufferedReader.readLine()) != null) {
                stringBuffer.append(lineText).append("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                    reader = null;
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                    bufferedReader = null;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return stringBuffer.toString();
    }

    /**
     * @Description: 使用FileChannel
    */
    public static String getFileContent3(String filePath) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        RandomAccessFile randomAccessFile = new RandomAccessFile(filePath,"rw");
//        String readLineText = null;
//        while ((readLineText =randomAccessFile.readLine()) != null){
//            stringBuffer.append(readLineText);
//            System.out.println(new String(readLineText.getBytes("ISO-8859-1"),"UTF-8"));
//        }
        FileChannel fileChannel = randomAccessFile.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(256);
        int byteReads = fileChannel.read(byteBuffer);
        while (byteReads != -1){
            System.out.println("Read:" + byteReads);
            byteBuffer.flip();
            byte[] byteArray = new byte[256];
            int i = 0;
            while (byteBuffer.hasRemaining()){
                byte b = byteBuffer.get();
                byte[] b1 = new byte[1];
                b1[0] = b;
                if (b==10 || b==13) {
                    System.out.println("回车");
                }
                byteArray[i++] = b;
//                System.out.print((char)byteBuffer.get());
            }

            String array[] = new String(byteArray, "UTF-8").split("\r\n");
            for (String str : array) {
                System.out.println(str);
            }
            System.out.println(new String(byteArray, "UTF-8"));
            byteBuffer.clear();
            byteReads = fileChannel.read(byteBuffer);
        }
        randomAccessFile.close();
        return stringBuffer.toString();
    }

    public static void getReadComWords(String sourceFilePath1,String sourceFilePath2, String targetFilePath) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(targetFilePath))));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(targetFilePath));//第二种写法：使用FileWriter
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<String> list3 = new ArrayList<>();
        String str1[] = getFileContent(sourceFilePath1).split("\n");
        String str2[] = getFileContent2(sourceFilePath2).split("\n");
        for (String str : str1) {
            list1.add(str);
        }
        for (String str : str2) {
            list2.add(str);
        }
        list1.retainAll(list2);
        for (String str : list1) {
            System.out.println(str);
            bufferedWriter.write(str+"\r\n");
        }
        bufferedWriter.close();
    }

    /**
     * 用filechannel进行文件复制
     */
    public static void fileCopyWithFileChannel(String fromFilePath, String toFilePath) {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        FileChannel fileChannelInput = null;
        FileChannel fileChannelOutput = null;
        try {
            fileInputStream = new FileInputStream(new File(fromFilePath));
            fileOutputStream = new FileOutputStream(new File(toFilePath));
            //得到fileInputStream的文件通道
            fileChannelInput = fileInputStream.getChannel();
            //得到fileOutputStream的文件通道
            fileChannelOutput = fileOutputStream.getChannel();
            //将fileChannelInput通道的数据，写入到fileChannelOutput通道
            fileChannelInput.transferTo(0, fileChannelInput.size(), fileChannelOutput);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileInputStream != null)
                    fileInputStream.close();
                if (fileChannelInput != null)
                    fileChannelInput.close();
                if (fileOutputStream != null)
                    fileOutputStream.close();
                if (fileChannelOutput != null)
                    fileChannelOutput.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        String sourceFilePath1 = "G:\\temp\\11.txt";
        String sourceFilePath2 = "G:\\temp\\22.txt";
        String targetFilePath = "G:\\temp\\33.txt";
//        getReadComWords(sourceFilePath1, sourceFilePath2, targetFilePath);
        getFileContent3(targetFilePath);

//        fileCopyWithFileChannel("G:\\temp\\11.txt", "G:\\temp\\44.txt");//文件复制
    }
}
