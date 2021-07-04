package java;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @ClassName UnitConversion
 * @Description TODO
 * @Author yangxiaobo
 * @Date 2021/3/30 14:07
 * @Version 1.0
 */
public class UnitConversion {
    private static final BigDecimal BASE = new BigDecimal(1024);

    public static void main(String[] args) {
        StorageCapacity storageCapacity = convertByteSmartly(-102300000000L);
        System.out.println(storageCapacity.capacity+" "+ storageCapacity.getStorageUnit());
        storageCapacity = convertByteSmartly(-102300000000L,EnumStorageUnit.BYTE);
        System.out.println(storageCapacity.capacity+" "+ storageCapacity.getStorageUnit());
        storageCapacity = convertByteSmartly(-1023L,EnumStorageUnit.KiB);
        System.out.println(storageCapacity.capacity+" "+ storageCapacity.getStorageUnit());
        storageCapacity = convertByteSmartly(102300000000L,EnumStorageUnit.BYTE);
        System.out.println(storageCapacity.capacity+" "+ storageCapacity.getStorageUnit());
        storageCapacity = convertByteSmartly(1023L,EnumStorageUnit.GiB);
        System.out.println(storageCapacity.capacity+" "+ storageCapacity.getStorageUnit());
        storageCapacity = convertByteSmartly(10240L,EnumStorageUnit.PiB);
        System.out.println(storageCapacity.capacity+" "+ storageCapacity.getStorageUnit());

    }

    /**
     * 智能转换存储单位
     * @return com.ctsi.hypercenter.common.util.StorageUtil.StorageCapacity
     * @createTime：2020-10-15 11:45
     * @author: chengyu
     */
    public static StorageCapacity convertByteSmartly(Long byteSize){
        if (byteSize == null) {
            return null;
        }
        BigDecimal capacity = new BigDecimal(byteSize);
        for (int i = 1 ; i < 6 ; i++){
            capacity = capacity.divide(BASE);
            if (capacity.max(BASE).equals(BASE)&&!capacity.equals(BASE)){
                return new StorageCapacity(capacity.setScale(3, RoundingMode.HALF_UP).doubleValue(),EnumStorageUnit.getInstance(i));
            }
        }
        return new StorageCapacity(capacity.setScale(3, RoundingMode.HALF_UP).doubleValue(),EnumStorageUnit.getInstance(5));
    }

    /**
     * 智能转换存储单位
     * @return com.ctsi.hypercenter.common.util.StorageUtil.StorageCapacity
     * @createTime：2020-10-15 11:45
     * @author: chengyu
     */
    public static StorageCapacity convertByteSmartly(Long size,EnumStorageUnit oldUnit){
        if (size == null) {
            return null;
        }
        BigDecimal capacity = new BigDecimal(size);
        if (capacity.abs().longValue()<BASE.longValue()) {
            return new StorageCapacity(capacity.doubleValue(),oldUnit);
        }
        for (int i = oldUnit.getCode()+1 ; i < 6 ; i++){
            capacity = capacity.divide(BASE);
            if (capacity.longValue()>=BASE.longValue()||capacity.abs().longValue()>=BASE.longValue()){
                continue;
            }
            return new StorageCapacity(capacity.setScale(3, RoundingMode.HALF_UP).doubleValue(),EnumStorageUnit.getInstance(i));
        }
        return new StorageCapacity(capacity.setScale(3, RoundingMode.HALF_UP).doubleValue(),EnumStorageUnit.getInstance(5));
    }


    public static class StorageCapacity{

        public StorageCapacity(Double capacity, EnumStorageUnit storageUnit) {
            this.capacity = capacity;
            this.storageUnit = storageUnit;
        }

        @Override public String toString() {
            return capacity+storageUnit.name();
        }

        private Double capacity;

        private EnumStorageUnit storageUnit;

        public Double getCapacity() {
            return capacity;
        }

        public void setCapacity(Double capacity) {
            this.capacity = capacity;
        }

        public EnumStorageUnit getStorageUnit() {
            return storageUnit;
        }

        public void setStorageUnit(EnumStorageUnit storageUnit) {
            this.storageUnit = storageUnit;
        }
    }

    /**
     * 存储及计量单位
     * @author: chengyu
     * @create: 2020-09-18 10:38
     **/
    public enum EnumStorageUnit {

        BYTE(0),KiB(1),MiB(2),GiB(3),TiB(4),PiB(5);

        private Integer code;

        EnumStorageUnit(Integer code){
            this.code = code;
        }

        public static EnumStorageUnit getInstance(Integer code){
            for(EnumStorageUnit unit: EnumStorageUnit.values()){
                if (unit.code.equals(code)){
                    return unit;
                }
            }
            return null;
        }

        public Integer getCode(){
            return this.code;
        }

    }

}
