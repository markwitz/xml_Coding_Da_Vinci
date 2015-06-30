
$ ->
  $('.author-info-button').hide()
  $('.next-slide').hide()
  windowHeight = $(window).height()
  $('.container').css('width': '900')
  $('.question-box').css('height': windowHeight)
  $('.hoverable').on 'click', ->
    parent = $(this).parent()
    for answer in parent.find('.answer')
      $(answer).removeClass('hoverable')
      if $(answer).data('right') == true
        $(answer).addClass('btn-success')
      else
        $(answer).addClass('btn-danger')
    parent.find('.author-info-button').show()
    parent.find('.next-slide').show()
