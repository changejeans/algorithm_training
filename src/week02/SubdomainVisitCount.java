package week02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubdomainVisitCount {
        public List<String> subdomainVisits(String[] cpdomains) {
            Map<String,Integer> map = new HashMap<>();
            for (String cpdomain : cpdomains) {
                if (!cpdomain.contains(" ")){
                    continue;
                }
                String[] splitValue = cpdomain.split(" ");
                int count = Integer.valueOf(splitValue[0]);
                String domain = String.valueOf(splitValue[1]);

                map.put(domain, map.getOrDefault(domain, 0) + count);

                while (domain.indexOf(".") != -1) {
                    String str = domain.substring(domain.indexOf(".") + 1);
                    map.put(str, map.getOrDefault(str, 0) + count);
                    domain = str;
                }
            }


            List<String> list = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                list.add(entry.getValue()+" " + entry.getKey());
            }
            return list;
        }



        public static void main(String[] args) {
            SubdomainVisitCount s = new SubdomainVisitCount();
            String[] array = new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
            List<String> list = s.subdomainVisits(array);
            System.out.println(list);

        }
}
