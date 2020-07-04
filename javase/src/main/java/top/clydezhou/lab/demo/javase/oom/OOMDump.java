/**
 * 
 */
package top.clydezhou.lab.demo.javase.oom;

/**
 * 验证 -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=参数
 * @author chows
 * Date:2019-12-04 10:12:27
 */
public class OOMDump {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        /* 1. 使用eclipse 打包到本地dump.jar
         * 2. java -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=F:\tmp\testdump -jar dump.jar
         * 3. 使用jdk bin目录下的jvisualvm.exe 点击文件->点击载入->选择文件类型为堆 dump->选择文件查看
         */
        long[] buf = new long[Integer.MAX_VALUE/16];
        System.out.println("ok");
        long[] buf2 = new long[Integer.MAX_VALUE/16];
        System.out.println("ok2");
        long[] buf3 = new long[Integer.MAX_VALUE/16];
        System.out.println("ok3");
        long[] buf4 = new long[Integer.MAX_VALUE/16];
        System.out.println("ok4");
    }
}
