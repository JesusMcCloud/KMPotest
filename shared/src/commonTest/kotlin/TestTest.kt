import io.kotest.core.Platform
import io.kotest.core.platform
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class TestTest: FreeSpec(  {

    println("Test running on $platform")

    "Let's see" - {
        "What's what" {
            3 shouldBe 3


        }
    }
})