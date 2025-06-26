rootProject.name = "EchoVote"

val app = ":app"
val core = ":core"
val features = ":features"

include(app)
include(*modules(core))
include(features)

private fun modules(name: String) = arrayOf(
    name,
    "$name:data",
    "$name:domain",
    "$name:presentation"
)