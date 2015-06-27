Rails.application.routes.draw do
  get 'quiz/index'
  get '/quiz', to: 'quiz#index'
  get '/member', to: 'default#member'
end
