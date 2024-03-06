import org.koin.dsl.module

val modules = module {
    single<RocketRepository> { RocketRepositoryImpl() }
}