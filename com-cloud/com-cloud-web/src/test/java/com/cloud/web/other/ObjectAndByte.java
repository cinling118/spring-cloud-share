package com.cloud.web.other;

import java.io.*;

/**
 * Object与byte[]，互相转化
*/
public class ObjectAndByte {

    /**
     * 对象转数组
     * @param obj
     * @return
     */
    public byte[] toByteArray (Object obj) {
        byte[] bytes = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(obj);
            oos.flush();
            bytes = bos.toByteArray();
            oos.close();
            bos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return bytes;
    }

    /**
     * 数组转对象
     * @param bytes
     * @return
     */
    public Object toObject (byte[] bytes) {
        Object obj = null;
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bis);
            obj = ois.readObject();
            ois.close();
            bis.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return obj;
    }

    public static void main(String[] args) {
        TestBean tb = new TestBean();
        tb.setName("daqing");
        tb.setValue("1234567890");

        ObjectAndByte oa = new ObjectAndByte();
        byte[] b = oa.toByteArray(tb);
        System.out.println(new String(b));

        System.out.println("=======================================");

        TestBean teb = (TestBean) oa.toObject(b);
        System.out.println(teb.getName());
        System.out.println(teb.getValue());
    }

}

class TestBean implements Serializable {

    private String name;

    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}