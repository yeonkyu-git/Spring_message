package hello.itemservice.message;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;

import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class MessageSourceTest {

    @Autowired
    MessageSource ms;

    @Test
    public void helloMessage() throws Exception {
        String result = ms.getMessage("hello", null, null);
        assertThat(result).isEqualTo("hello");
    }

    @Test
    void notFoundMessageCode() {
        Assertions.assertThatThrownBy(() -> ms.getMessage("no_code", null, null))
                .isInstanceOf(NoSuchMessageException.class);
    }

    @Test
    void argumentMessage() {
        String result = ms.getMessage("hello.name", new Object[]{"Spring"}, null);
        assertThat(result).isEqualTo("hello Spring");
    }

    @Test
    void defaultLang() {
        assertThat(ms.getMessage("hello", null, null)).isEqualTo("hello");
        assertThat(ms.getMessage("hello", null, Locale.KOREA)).isEqualTo("안녕");
        assertThat(ms.getMessage("hello", null, Locale.ENGLISH)).isEqualTo("hello");
    }
}
