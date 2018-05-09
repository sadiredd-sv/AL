import java.util.*;

class Group {
    List<String> names;
    int id;

    public Group(List<String> names) {
        this.names = names;
    }
}

class AlTest {

    public static List<Group> allGroups(List<String> names) {
        int length = names.size();

        Random r = new Random();

        Set<Integer> set = new HashSet<>();

        List<Group> output = new ArrayList<Group>();
        List<String> members = new ArrayList<String>();

        for(int k=0; k<length/3;k++) {

            for(int i=0; i <3; i++) {
                int id = r.nextInt(length);

                    while (set.contains(id)) {
                        id = id + 1;
                        if (id >= length)
                            id = id % length;
                    }
                    set.add(id);

                System.out.println(names.get(id));
                members.add(names.get(id));
            }

            Group ob = new Group(members);
            System.out.println(ob.names);
            output.add(ob);
            members.clear();
            System.out.println();
        }


        return output;

    }

    public static void main(String args[]) {
        List<String> names = new ArrayList<>(Arrays.asList("A","B","C","D","E","F"));
        List<Group> output = allGroups(names);

    }
}