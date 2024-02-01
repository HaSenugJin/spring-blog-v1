package shop.mtcoding.blog;

import org.junit.jupiter.api.Test;

public class test {

    @Test
    public void count() {
        int totalCount = 4;
        int pagingCount = 3;
        int remainCount = totalCount % pagingCount;
        int totalPageCount = totalCount / pagingCount;
        System.out.println(totalPageCount);

        if (remainCount > 0) {
            totalPageCount = totalPageCount + 1;
        }

        System.out.println(totalPageCount);
    }
}