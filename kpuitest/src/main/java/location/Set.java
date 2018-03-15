package location;

public enum Set {
    COMMON("XYZ");

    private final String value;

    Set(String value) {
        this.value = value;
    }

//    public static Set fromTypeName(String typeName) {
//        for (Set type : Set.values()) {
//            if (type.getValue().equals(typeName)) {
//                return type;
//            }
//        }
//        return null;
//    }

    public String getValue(){
        return this.value;
    }
}
