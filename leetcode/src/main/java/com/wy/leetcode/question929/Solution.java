package com.wy.leetcode.question929;

import java.util.HashSet;

/**
 * @author wangyong
 * @date 2019/5/24
 * @description
 * 每封电子邮件都由一个本地名称和一个域名组成，以 @ 符号分隔。
 *
 * 例如，在 alice@com.wy.leetcode.com中， alice 是本地名称，而 com.wy.leetcode.com 是域名。
 *
 * 除了小写字母，这些电子邮件还可能包含 '.' 或 '+'。
 *
 * 如果在电子邮件地址的本地名称部分中的某些字符之间添加句点（'.'），则发往那里的邮件将会转发到本地名称中没有点的同一地址。例如，"alice.z@com.wy.leetcode.com” 和 “alicez@com.wy.leetcode.com” 会转发到同一电子邮件地址。 （请注意，此规则不适用于域名。）
 *
 * 如果在本地名称中添加加号（'+'），则会忽略第一个加号后面的所有内容。这允许过滤某些电子邮件，例如 m.y+name@email.com 将转发到 my@email.com。 （同样，此规则不适用于域名。）
 *
 * 可以同时使用这两个规则。
 *
 * 给定电子邮件列表 emails，我们会向列表中的每个地址发送一封电子邮件。实际收到邮件的不同地址有多少？
 *
 *
 *
 * 示例：
 *
 * 输入：["test.email+alex@com.wy.leetcode.com","test.e.mail+bob.cathy@com.wy.leetcode.com","testemail+david@lee.tcode.com"]
 * 输出：2
 * 解释：实际收到邮件的是 "testemail@com.wy.leetcode.com" 和 "testemail@lee.tcode.com"。
 */
public class Solution {
    /**
     * 使用split
     *
     * @param emails
     * @return
     */
    public static int numUniqueEmails(String[] emails) {
        HashSet<String> result = new HashSet<>();
        for (String str : emails) {
            String[] mailSections = str.split("@");
            String[] localSections = mailSections[0].split("\\+");
            String finalLocal = localSections[0].replaceAll("\\.", "");
            result.add(finalLocal + mailSections[1]);
        }
        return result.size();
    }

    /**
     * 效率更高的一种解法，split效率低
     *
     * @param emails
     * @return
     */
    public static int numUniqueEmails1(String[] emails) {
        HashSet<String> result = new HashSet<>();
        for (String element : emails) {
            int i = element.indexOf("@");
            String local = element.substring(0, i - 1);
            String domain = element.substring(i);
            int i1 = local.indexOf("+");
            String finalLocal = local.substring(0, i1 - 1).replaceAll("\\.", "");
            result.add(finalLocal + domain);
        }
        return result.size();
    }

    public static void main(String[] args) {
        String[] mails = {"test.email+alex@com.wy.leetcode.com", "test.e.mail+bob.cathy@com.wy.leetcode.com", "testemail+david@lee.tcode.com"};
        System.out.println(numUniqueEmails1(mails));
    }
}
