import java.util.*;

class Group {
    List<String> names;
    int id;

    public Group(List<String> names, int id) {
        this.names = new ArrayList<>();
        for(String name : names)
            this.names.add(name);
        this.id=id;
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

                System.out.println(id);
                members.add(names.get(id));
            }

            Group ob = new Group(members,k);
            output.add(ob);
            members.clear();
            System.out.println();
        }


        return output;

    }

    public static void main(String args[]) {
        List<String> names = new ArrayList<>(Arrays.asList("A","B","C","D","E","F"));
        List<Group> output = allGroups(names);

        // Print output
        for(Group g : output) {
            System.out.println("Group id :" + g.id+",Members :"+g.names);
        }
    }
}