package mengka.directByteBuffer_01;

/**
 * �����ڴ棺
 * �����ڴ��Ǵ�����JVM�ܿ�֮���һ���ڴ�����������ǲ���JVM�Ĺܿأ�
 *
 * �����ڴ棺
 * ��JVM���ܿص�Java�����ڴ棬����ƽʱ��Java�д����Ķ��󶼴��ڶ����ڴ��У�
 * JVM������������ջ���ͳһ�������ǵ��ڴ棻
 *
 * �����١���
 * ��������Ҫ���һ�����ļ��ж����ݵ������ڴ�Ĳ�������FileChannelImpl.read(HeapByteBuffer)��
 * ����ʵ����File I/O�Ὣ���ݶ��������ڴ��У�Ȼ������ڴ��ٽ����ݿ����������ڴ棬�������ǾͶ������ļ��е��ڴ档
 *
 * �����ڡ���
 * ֱ��ʹ�ö����ڴ棬��DirectByteBuffer�����ַ�ʽ��ֱ���ڶ������һ���ڴ�(����native memory)���洢���ݣ�
 * ����ͨ��JNIֱ�ӽ����ݶ�/д�������ڴ��С�
 *
 * ��ʲô�����ʹ�ö����ڴ棿��
 * 1.�����ڴ����������������еȻ�ϳ��Ķ���( ������������ڽ϶̵Ķ�����YGC��ʱ��ͱ������ˣ��Ͳ����ڴ��ڴ����������ڽϳ��Ķ�����FGC��Ӧ����ɵ�����Ӱ�� )
 * 2.ֱ�ӵ��ļ���������������I/O������ֱ��ʹ�ö����ڴ������ȥ�ڴ���û��ڴ濽����ϵͳ�ڴ�Ĳ�������ΪI/O������ϵͳ�ں��ڴ���豸���ͨ�ţ�������ͨ������ֱ�Ӻ�����ͨ�ŵ�;
 * 3.ͬʱ��������ʹ��"��+�����ڴ�"����Ϸ�ʽ�������������ڽ϶̣����漰��I/O�����Ķ�����ж����ڴ����ʹ�á�( Netty�о�ʹ���˸÷�ʽ )
 *
 * �����ڴ�����������������ڽ϶̵Ŀɱ���󣬶������ڴ��������������еȻ�ϳ��Ķ���
 *
 * ���������ڴ���ص㣺
 * 1.���ڴ��ڴ������õ�������;
 * 2.����������ͣ�ٵĸ��ƿ������Ըо���;
 * 3.�ڽ��̼���Թ����������������ĸ���;
 *
 * @author mengka
 * @date 2017/08/28.
 */
public class directByteBuffer_01 {

    public static void main(String[] args){

    }
}