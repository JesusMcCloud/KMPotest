import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class TestTest: FreeSpec(  {

    "Let's see" - {
        "What's what" {
            3 shouldBe 2
        }
    }
})