Rails.application.routes.draw do

  # get '/quiz', to: 'quizzes#index'
  get '/member', to: 'default#member'
end
