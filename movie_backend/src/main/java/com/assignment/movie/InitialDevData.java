package com.assignment.movie;

import com.assignment.movie.model.CastModel;
import com.assignment.movie.model.LookupCategoryModel;
import com.assignment.movie.model.MovieModel;
import com.assignment.movie.repository.CastRepository;
import com.assignment.movie.repository.CategoryRepository;
import com.assignment.movie.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
//@Profile("dev")
public class InitialDevData implements ApplicationRunner {

    private final CategoryRepository categoryRepository;
    private final CastRepository castRepository;
    private final MovieRepository movieRepository;

    @Override
    public void run(ApplicationArguments args) {
        log.info(".... init application ...");
        List<LookupCategoryModel> lookupCategoryModelList = categoryRepository.findAll();
        if (lookupCategoryModelList.isEmpty()) {
            LookupCategoryModel categoryModel = LookupCategoryModel.builder()
                    .name("Adventure")
                    .build();
            LookupCategoryModel categoryModel1 = LookupCategoryModel.builder()
                    .name("Horror")
                    .build();
            LookupCategoryModel categoryModel2 = LookupCategoryModel.builder()
                    .name("Drama")
                    .build();
            LookupCategoryModel categoryModel3 = LookupCategoryModel.builder()
                    .name("Comedy")
                    .build();
            LookupCategoryModel adventure = categoryRepository.save(categoryModel);
            LookupCategoryModel horror = categoryRepository.save(categoryModel1);
            LookupCategoryModel drama = categoryRepository.save(categoryModel2);
            LookupCategoryModel comedy = categoryRepository.save(categoryModel3);
            ArrayList<LookupCategoryModel> horrorCategory = new ArrayList<LookupCategoryModel>() {
                {
                    add(horror);
                }
            };
            ArrayList<LookupCategoryModel> adventureCategory = new ArrayList<LookupCategoryModel>() {
                {
                    add(adventure);
                }
            };
            ArrayList<LookupCategoryModel> dramaCategory = new ArrayList<LookupCategoryModel>() {
                {
                    add(drama);
                }
            };
            ArrayList<LookupCategoryModel> comedyCategory = new ArrayList<LookupCategoryModel>() {
                {
                    add(comedy);
                }
            };
            //
            CastModel cast = CastModel.builder()
                    .fullName("Johnny Depp")
                    .age(55)
                    .insertTime(LocalDateTime.now())
                    .imagePath("/images/depp.jpg")
                    .build();
            CastModel castModel = castRepository.save(cast);

            CastModel cast1 = CastModel.builder()
                    .fullName("Al Pacino")
                    .age(75)
                    .insertTime(LocalDateTime.now())
                    .imagePath("/images/pacino.jpg")
                    .build();
            CastModel castModel1 = castRepository.save(cast1);


            CastModel cast2 = CastModel.builder()
                    .fullName("Robert De Niro")

                    .age(75)
                    .insertTime(LocalDateTime.now())
                    .imagePath("/images/niro.jpg")
                    .build();
            CastModel castModel2 = castRepository.save(cast2);


            CastModel cast3 = CastModel.builder()
                    .fullName("Kevin Spacey")

                    .age(65)
                    .insertTime(LocalDateTime.now())
                    .imagePath("/images/spacey.jpg")
                    .build();
            CastModel castModel3 = castRepository.save(cast3);


            CastModel cast4 = CastModel.builder()
                    .fullName("Brad Pitt")

                    .age(65)
                    .insertTime(LocalDateTime.now())
                    .imagePath("/images/pitt.jpg")
                    .build();
            CastModel castModel4 = castRepository.save(cast4);

            CastModel cast5 = CastModel.builder()
                    .fullName("Leonardo DiCaprio")

                    .age(50)
                    .insertTime(LocalDateTime.now())
                    .imagePath("/images/dicaprio.jpg")
                    .build();
            CastModel castModel5 = castRepository.save(cast5);


            CastModel cast6 = CastModel.builder()
                    .fullName("Angelina Jolie")

                    .age(45)
                    .insertTime(LocalDateTime.now())
                    .imagePath("/images/jolie.jpg")
                    .build();
            CastModel castModel6 = castRepository.save(cast6);


            CastModel cast7 = CastModel.builder()
                    .fullName("Kate Winslet")

                    .age(45)
                    .insertTime(LocalDateTime.now())
                    .imagePath("/images/kate.jpg")
                    .build();
            CastModel castModel7 = castRepository.save(cast7);


            CastModel cast8 = CastModel.builder()
                    .fullName("Charlize Theron")

                    .age(50)
                    .insertTime(LocalDateTime.now())
                    .imagePath("/images/theron.jpg")
                    .build();
            CastModel castModel8 = castRepository.save(cast8);


            CastModel cast9 = CastModel.builder()
                    .fullName("Keira Knightley")

                    .age(35)
                    .insertTime(LocalDateTime.now())
                    .imagePath("/images/keira.jpg")
                    .build();
            CastModel castModel9 = castRepository.save(cast9);


            CastModel cast10 = CastModel.builder()
                    .fullName("Scarlett Johansson")
                    .age(45)
                    .insertTime(LocalDateTime.now())
                    .imagePath("/images/scarlett.jpg")
                    .build();
            CastModel castModel10 = castRepository.save(cast10);

            List<MovieModel> movieModels = new ArrayList<>();

            Long movieId = 1L;

            MovieModel conjuring = MovieModel.builder()
                    .title("The Conjuring")
                    .imagePath("/images/conjuring.jpg")
                    .categories(horrorCategory)
                    .year(2013)
                    .casts(new ArrayList<CastModel>() {
                        {
                            add(castModel);
                            add(castModel7);
                        }
                    })
                    .budget(50)
                    .insertTime(LocalDateTime.now())
                    .build();
            movieModels.add(conjuring);

            MovieModel thing = MovieModel.builder()
                    .title("The Thing")

                    .imagePath("/images/thing.jpg")
                    .categories(horrorCategory)
                    .year(1982)
                    .casts(new ArrayList<CastModel>() {
                        {
                            add(castModel2);
                            add(castModel8);
                        }
                    })
                    .budget(40)
                    .insertTime(LocalDateTime.now())
                    .build();
            movieModels.add(thing);
            MovieModel exorcist = MovieModel.builder()
                    .title("The Exorcist")

                    .imagePath("/images/exorcist.jpg")
                    .year(1973)
                    .categories(horrorCategory)
                    .casts(new ArrayList<CastModel>() {
                        {
                            add(castModel3);
                            add(castModel9);
                        }
                    })
                    .budget(40)
                    .insertTime(LocalDateTime.now())
                    .build();
            movieModels.add(exorcist);

            MovieModel texas = MovieModel.builder()
                    .title("The Texas Chain Saw Massacre")

                    .year(1974)
                    .imagePath("/images/texas.jpg")
                    .categories(horrorCategory)
                    .casts(new ArrayList<CastModel>() {
                        {
                            add(castModel4);
                            add(castModel10);
                        }
                    })
                    .budget(40)
                    .insertTime(LocalDateTime.now())
                    .build();
            movieModels.add(texas);

            MovieModel joker = MovieModel.builder()
                    .title("The Joker")

                    .year(2019)
                    .imagePath("/images/joker.jpg")
                    .categories(dramaCategory)
                    .casts(new ArrayList<CastModel>() {
                        {
                            add(castModel5);
                            add(castModel10);
                        }
                    })
                    .budget(80)
                    .insertTime(LocalDateTime.now())
                    .build();
            movieModels.add(joker);

            MovieModel titanic = MovieModel.builder()
                    .title("Titanic")

                    .year(2019)
                    .imagePath("/images/titanic.jpg")
                    .categories(dramaCategory)
                    .casts(new ArrayList<CastModel>() {
                        {
                            add(castModel5);
                            add(castModel7);
                        }
                    })
                    .budget(100)
                    .insertTime(LocalDateTime.now())
                    .build();
            movieModels.add(titanic);

            MovieModel enemy = MovieModel.builder()
                    .title("Titanic")

                    .year(2014)
                    .imagePath("/images/enemy.jpg")
                    .categories(dramaCategory)
                    .casts(new ArrayList<CastModel>() {
                        {
                            add(castModel);
                            add(castModel10);
                        }
                    })
                    .budget(100)
                    .insertTime(LocalDateTime.now())
                    .build();
            movieModels.add(enemy);

            MovieModel mebeforeyou = MovieModel.builder()
                    .title("Me Before You")

                    .year(2016)
                    .imagePath("/images/mebeforeyou.jpg")
                    .categories(dramaCategory)
                    .casts(new ArrayList<CastModel>() {
                        {
                            add(castModel3);
                            add(castModel6);
                        }
                    })
                    .budget(50)
                    .insertTime(LocalDateTime.now())
                    .build();
            movieModels.add(mebeforeyou);

            MovieModel hangover = MovieModel.builder()
                    .title("Hangover")

                    .year(2012)
                    .imagePath("/images/hangover.jpg")
                    .categories(comedyCategory)
                    .casts(new ArrayList<CastModel>() {
                        {
                            add(castModel5);
                            add(castModel9);
                        }
                    })
                    .budget(50)
                    .insertTime(LocalDateTime.now())
                    .build();
            movieModels.add(hangover);

            MovieModel truman = MovieModel.builder()
                    .title("The Truman Show")

                    .year(2012)
                    .imagePath("/images/truman.jpg")
                    .categories(comedyCategory)
                    .casts(new ArrayList<CastModel>() {
                        {
                            add(castModel1);
                            add(castModel10);
                        }
                    })
                    .budget(50)
                    .insertTime(LocalDateTime.now())
                    .build();
            movieModels.add(truman);

            MovieModel stepbrothers = MovieModel.builder()
                    .title("The Stepbrothers")

                    .year(1995)
                    .imagePath("/images/stepbrothers.jpg")
                    .categories(comedyCategory)
                    .casts(new ArrayList<CastModel>() {
                        {
                            add(castModel2);
                            add(castModel7);
                        }
                    })
                    .budget(30)
                    .insertTime(LocalDateTime.now())
                    .build();
            movieModels.add(stepbrothers);

            MovieModel tintin = MovieModel.builder()
                    .title("The Adventures of Tintin")

                    .year(2011)
                    .imagePath("/images/tintin.jpg")
                    .categories(adventureCategory)
                    .casts(new ArrayList<CastModel>() {
                        {
                            add(castModel3);
                            add(castModel7);
                        }
                    })
                    .budget(90)
                    .insertTime(LocalDateTime.now())
                    .build();
            movieModels.add(tintin);

            MovieModel fury = MovieModel.builder()
                    .title("Fury")

                    .year(2014)
                    .imagePath("/images/fury.jpg")
                    .categories(adventureCategory)
                    .casts(new ArrayList<CastModel>() {
                        {
                            add(castModel4);
                            add(castModel6);
                        }
                    })
                    .budget(120)
                    .insertTime(LocalDateTime.now())
                    .build();
            movieModels.add(fury);

            MovieModel widows = MovieModel.builder()
                    .title("Widows")

                    .year(2009)
                    .imagePath("/images/widows.jpg")
                    .categories(adventureCategory)
                    .casts(new ArrayList<CastModel>() {
                        {
                            add(castModel5);
                            add(castModel10);
                        }
                    })
                    .budget(30)
                    .insertTime(LocalDateTime.now())
                    .build();
            movieModels.add(widows);

            MovieModel whiplash = MovieModel.builder()
                    .title("Whiplash")
                    .year(2013)
                    .imagePath("/images/whiplash.jpg")
                    .categories(adventureCategory)
                    .casts(new ArrayList<CastModel>() {
                        {
                            add(castModel5);
                            add(castModel10);
                        }
                    })
                    .budget(40)
                    .insertTime(LocalDateTime.now())
                    .build();
            movieModels.add(whiplash);

            MovieModel terminator = MovieModel.builder()
                    .title("Whiplash")
                    .year(2013)
                    .imagePath("/images/terminator.jpg")
                    .categories(adventureCategory)
                    .casts(new ArrayList<CastModel>() {
                        {
                            add(castModel1);
                            add(castModel9);
                        }
                    })
                    .budget(40)
                    .insertTime(LocalDateTime.now())
                    .build();
            movieModels.add(terminator);
            MovieModel bvs = MovieModel.builder()
                    .title("Batman vs Superman")

                    .year(2016)
                    .imagePath("/images/bvs.jpg")
                    .categories(adventureCategory)
                    .casts(new ArrayList<CastModel>() {
                        {
                            add(castModel2);
                            add(castModel8);
                        }
                    })
                    .budget(200)
                    .insertTime(LocalDateTime.now())
                    .build();
            movieModels.add(whiplash);

            movieRepository.saveAll(movieModels);

        }
    }
}




