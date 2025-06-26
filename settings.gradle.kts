rootProject.name = "EchoVote"

val app = ":app"
val core = ":core"
val features = ":features"

val home = "$features:home"

include(app)
include(*modules(core))
include(features)

include(*modules(home))

private fun modules(name: String) = arrayOf(
    name,
    "$name:data",
    "$name:domain",
    "$name:presentation"
)