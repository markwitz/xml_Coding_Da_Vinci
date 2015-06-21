require File.expand_path('../boot', __FILE__)

require 'rails/all'

Bundler.require(*Rails.groups)

module XmlCodingDaVinci
  class Application < Rails::Application
    config.sass.preferred_syntax = :sass
    config.active_record.raise_in_transactional_callbacks = true
  end
end
