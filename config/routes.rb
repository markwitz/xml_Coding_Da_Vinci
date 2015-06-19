Rails.application.routes.draw do
  resources :answers
  resources :questions
  get '/member', to: 'default#member'
end
