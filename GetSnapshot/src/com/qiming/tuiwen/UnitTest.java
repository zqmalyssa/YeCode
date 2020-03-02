package com.qiming.tuiwen;

import org.junit.Assert;
import org.junit.Test;

public class UnitTest {

  private static final String invalidFormat = "Invalid format";
  private static final String conflictFound = "Conflict found at ";
  private GetSnapshot getSnapshot = new GetSnapshot();

  /**
   * 文本空，格式错误
   */
  @Test
  public void data_empty() {

    String source = "";
    String result = getSnapshot.getSnapShot(source, "351055db-33e6-4f9b-bfe1-16f1ac446ac1");
    Assert.assertEquals(result, invalidFormat);

  }

  /**
   * 传参uuid，格式错误
   */
  @Test
  public void id_format_error() {

    String source = "e4e87cb2-8e9a-4749-abb6-26c59344dfee\n"
        + "2016/09/02 22:30:46\n"
        + "cat1 10 9\n"
        + "\n"
        + "351055db-33e6-4f9b-bfe1-16f1ac446ac1\n"
        + "2016/09/02 22:30:52\n"
        + "cat1 10 9 2 -1\n"
        + "cat2 2 3\n"
        + "\n"
        + "dcfa0c7a-5855-4ed2-bc8c-4accae8bd155\n"
        + "2016/09/02 22:31:02\n"
        + "cat1 12 8 3 4";
    String result = getSnapshot.getSnapShot(source, "351055db-33e6-4f9b-bfe1");
    Assert.assertEquals(result, invalidFormat);

  }

  /**
   * 文本UUID，格式错误
   */
  @Test
  public void uuid_format_error() {

    String source = "e4e87cb2-8e9a-4749-abb6\n"
        + "2016/09/02 22:30:46\n"
        + "cat1 10 9 8\n"
        + "\n"
        + "351055db-33e6-4f9b-bfe1\n"
        + "2016/09/02 22:30:52\n"
        + "cat1 10 9 2 -1\n"
        + "cat2 2 3\n"
        + "\n"
        + "dcfa0c7a-5855-4ed2-bc8c\n"
        + "2016/09/02 22:31:02\n"
        + "cat1 12 8 3 4";
    String result = getSnapshot.getSnapShot(source, "351055db-33e6-4f9b-bfe1-16f1ac446ac1");
    Assert.assertEquals(result, invalidFormat);

  }

  /**
   * 文本时间，格式错误
   */
  @Test
  public void date_format_error() {

    String source = "e4e87cb2-8e9a-4749-abb6-26c59344dfee\n"
        + "2016/09/02 22:30\n"
        + "cat1 10 9\n"
        + "\n"
        + "351055db-33e6-4f9b-bfe1-16f1ac446ac1\n"
        + "2016/09/02 22:30\n"
        + "cat1 10 9 2 -1\n"
        + "cat2 2 3\n"
        + "\n"
        + "dcfa0c7a-5855-4ed2-bc8c-4accae8bd155\n"
        + "2016/09/02 22:31\n"
        + "cat1 12 8 3 4";
    String result = getSnapshot.getSnapShot(source, "351055db-33e6-4f9b-bfe1-16f1ac446ac1");
    Assert.assertEquals(result, invalidFormat);

  }

  /**
   * cat1 10 9 8 动物数据格式错误
   */
  @Test
  public void data_format_error() {

    String source = "e4e87cb2-8e9a-4749-abb6-26c59344dfee\n"
        + "2016/09/02 22:30:46\n"
        + "cat1 10 9 8\n"
        + "\n"
        + "351055db-33e6-4f9b-bfe1-16f1ac446ac1\n"
        + "2016/09/02 22:30:52\n"
        + "cat1 10 9 2 -1\n"
        + "cat2 2 3\n"
        + "\n"
        + "dcfa0c7a-5855-4ed2-bc8c-4accae8bd155\n"
        + "2016/09/02 22:31:02\n"
        + "cat1 12 8 3 4";
    String result = getSnapshot.getSnapShot(source, "351055db-33e6-4f9b-bfe1-16f1ac446ac1");
    Assert.assertEquals(result, invalidFormat);

  }


  /**
   * cat1 11 8 3 4，动物数据有误
   */
  @Test
  public void data_correct_error() {

    String source = "e4e87cb2-8e9a-4749-abb6-26c59344dfee\n"
        + "2016/09/02 22:30:46\n"
        + "cat1 10 9\n"
        + "\n"
        + "351055db-33e6-4f9b-bfe1-16f1ac446ac1\n"
        + "2016/09/02 22:30:52\n"
        + "cat1 10 9 2 -1\n"
        + "cat2 2 3\n"
        + "\n"
        + "dcfa0c7a-5855-4ed2-bc8c-4accae8bd155\n"
        + "2016/09/02 22:31:02\n"
        + "cat1 11 8 3 4";
    String result = getSnapshot.getSnapShot(source, "dcfa0c7a-5855-4ed2-bc8c-4accae8bd155");
    Assert.assertEquals(result, conflictFound + "dcfa0c7a-5855-4ed2-bc8c-4accae8bd155");

  }

  /**
   * 返回正确1
   */
  @Test
  public void data_correct_good1() {

    String source = "e4e87cb2-8e9a-4749-abb6-26c59344dfee\n"
        + "2016/09/02 22:30:46\n"
        + "cat1 10 9\n"
        + "\n"
        + "351055db-33e6-4f9b-bfe1-16f1ac446ac1\n"
        + "2016/09/02 22:30:52\n"
        + "cat1 10 9 2 -1\n"
        + "cat2 2 3\n"
        + "\n"
        + "dcfa0c7a-5855-4ed2-bc8c-4accae8bd155\n"
        + "2016/09/02 22:31:02\n"
        + "cat1 12 8 3 4";
    String result = getSnapshot.getSnapShot(source, "dcfa0c7a-5855-4ed2-bc8c-4accae8bd155");
    Assert.assertEquals(result, "cat1 12 8 3 4");

  }


  /**
   * 返回正确2
   */
  @Test
  public void data_correct_good2() {

    String source = "e4e87cb2-8e9a-4749-abb6-26c59344dfee\n"
        + "2016/09/02 22:30:46\n"
        + "cat1 10 9\n"
        + "\n"
        + "351055db-33e6-4f9b-bfe1-16f1ac446ac1\n"
        + "2016/09/02 22:30:52\n"
        + "cat1 10 9 2 -1\n"
        + "cat2 2 3\n"
        + "\n"
        + "dcfa0c7a-5855-4ed2-bc8c-4accae8bd155\n"
        + "2016/09/02 22:31:02\n"
        + "cat1 12 8 3 4";
    String result = getSnapshot.getSnapShot(source, "351055db-33e6-4f9b-bfe1-16f1ac446ac1");
    Assert.assertEquals(result, "cat1 10 9 2 -1\n" + "cat2 2 3");

  }

}
