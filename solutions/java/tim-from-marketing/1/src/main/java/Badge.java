class Badge {
    public String print(Integer id, String name, String department) {
        String result = "";

        if (id != null){
            result = result + ("[" + id.toString() + "] - ");
        }
        result = result + name + " - ";
        if (department != null){
            result = result + department.toUpperCase();
        }else{
            result = result + "OWNER";
        }
        return result;
    }
}
