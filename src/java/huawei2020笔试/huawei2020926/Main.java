package java.huawei2020笔试.huawei2020926;

import java.util.*;

public class Main{
    public static class cal {
        String name;
        int num = 0;
        List<cal> chile = new LinkedList<>();
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public int getNum() {
            return num;
        }
        public void setNum(int num) {
            this.num = num;
        }
        public List<cal> getChile() {
            return chile;
        }
        public void insertF(String f,String chile,Integer chileNum){
            boolean fla = false;
            int indexI = 0;
            for(int i=0;i<this.chile.size();i++){
                if(f.equals(this.chile.get(i).getName())){
                    this.chile.get(i).setNum(chileNum+this.chile.get(i).getNum());
                    this.setNum(this.getNum()+chileNum);
                    cal chilenode = new cal();
                    chilenode.setName(chile);
                    chilenode.setNum(chileNum);
                    int k = this.chile.get(i).getChile().size();
                    for(int j=0;j<this.chile.get(i).getChile().size();j++){
                        if(chileNum>this.chile.get(i).getChile().get(j).getNum()){
                            k=j;
                            break;
                        }
                    }
                    this.chile.get(i).getChile().add(k,chilenode);
                    indexI = i;
                    fla = true;
                    break;
                }
            }
            if(!fla){
                cal fnode = new cal();
                fnode.setName(f);
                fnode.setNum(chileNum);
                cal chilenode = new cal();
                chilenode.setName(chile);
                chilenode.setNum(chileNum);
                fnode.getChile().add(chilenode);
                this.getChile().add(fnode);
                this.setNum(this.getNum()+chileNum);
            }
            cal indexF = this.getChile().remove(indexI);
            int k = this.chile.size();
            for(int j=0;j<this.chile.size();j++){
                if(indexF.getNum()>this.chile.get(j).getNum()){
                    k=j;
                    break;
                }
            }
            this.getChile().add(k,indexF);

        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<String, Integer> calList = new HashMap<>();
        Map<String, cal> gfNode = new HashMap<>();
        String readLine = in.nextLine();
        readLine = in.nextLine();
        while (!readLine.equals("organization") && !readLine.equals("")) {
            calList.put(readLine.split(",")[0], Integer.parseInt(readLine.split(",")[1]));
            readLine = in.nextLine();
        }
        readLine = in.nextLine();
        readLine = in.nextLine();
        while (!readLine.equals("eof")) {
            String gf = readLine.split(",")[0];
            String f = readLine.split(",")[1];
            String chile = readLine.split(",")[2];
            Integer chileNum = calList.get(chile);
            if (gfNode.get(gf) != null) {
                gfNode.get(gf).insertF(f, chile, chileNum);
            } else {
                cal gfn = new cal();
                gfn.setNum(0);
                gfn.setName(gf);
                gfNode.put(gf, gfn);
                gfNode.get(gf).insertF(f, chile, chileNum);
            }
            readLine = in.nextLine();
        }
        gfNode.forEach((gfnodeName, gfnode) -> {
            System.out.println(gfnodeName + "<" + gfnode.getNum() + ">");
            for (int i = 0; i < gfnode.getChile().size(); i++) {
                System.out.println("-" + gfnode.getChile().get(i).getName() + "<" + gfnode.getChile().get(i).getNum() + ">");
                for (int j = 0; j < gfnode.getChile().get(i).getChile().size(); j++) {
                    System.out.println("--" + gfnode.getChile().get(i).getChile().get(j).getName() + "<" + gfnode.getChile().get(i).getChile().get(j).getNum() + ">");
                }
            }

        });
    }
}